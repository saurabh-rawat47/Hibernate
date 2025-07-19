package com.bunny.DemoHib;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {

		Configuration config = new Configuration().configure().addAnnotatedClass(Student1.class);

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();

		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();
		session.beginTransaction();

//		NativeQuery query =  session.createNativeQuery("select * from student1 where marks>60");
//		query.addEntity(Student1.class);
//		List<Student1> student = query.list();
//		for(Student1 o:student)
//		{
//			System.out.println(o);
//		}

		NativeQuery query = session.createNativeQuery("select name,marks from student1 where marks>60");
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List student = query.list();
		for (Object o : student) {
			Map m = (Map) o;
			System.out.println(m.get("name") + ":" + m.get("marks"));
		}

		session.getTransaction().commit();

	}
}
