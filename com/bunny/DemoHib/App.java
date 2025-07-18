package com.bunny.DemoHib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {

		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("HP");

		Student s = new Student();
		s.setRollno(1);
		s.setName("Saurabh");
		s.setMarks(90);
		s.getLaptop().add(laptop);
		laptop.getStudent().add(s);

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();

		SessionFactory sf = config.buildSessionFactory(registry);

		Session session1 = sf.openSession();

		session1.beginTransaction();
		session1.save(laptop);
		session1.save(s);

		
		Query query1 = session1.createQuery("from Laptop where lid = 101", Laptop.class);
		
		query1.setCacheable(true);
		Object o1 = query1.uniqueResult(); // Triggers SELECT
		System.out.println(o1);
		session1.getTransaction().commit();
		session1.close();
		
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Query  query2 = session2.createQuery("from Laptop where lid = 101", Laptop.class);

		query2.setCacheable(true);

		Object o2 = query2.uniqueResult(); // Triggers SELECT
		System.out.println(o2);
		session1.getTransaction().commit();
		session1.close();
		
//		TName tname = new TName();
//		tname.setFname("Sauarbh");
//		tname.setMname(".");
//		tname.setLname("Rawat");
//		Tony t = new Tony();
//		t.setId(4);
//		t.setName(tname);
//		t.setFcolor("Green");
//
//		Configuration con = new Configuration().configure().addAnnotatedClass(Tony.class);
//
//		StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
//
//		SessionFactory sf = con.buildSessionFactory(reg);
//
//		Session session = sf.openSession();
//
//		Transaction tx = session.beginTransaction();
//
////		t = (Tony)session.get(Tony.class, 2);
//
//		session.save(t);
//
//		tx.commit();
//		System.out.println(t);

	}
}
