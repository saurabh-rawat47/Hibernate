package com.bunny.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Configuration config = new Configuration().configure().addAnnotatedClass(Laptop2.class);

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();

		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();
		session.beginTransaction();

//		Laptop2 l = new Laptop2();
//		l.setLid(21);
//		l.setBrand("Asus");
//		l.setPrice(80000);
//		session.save(l);
		Laptop2 lap = session.load(Laptop2.class,14);
		System.out.println(lap);

		session.getTransaction().commit();

	}
}
