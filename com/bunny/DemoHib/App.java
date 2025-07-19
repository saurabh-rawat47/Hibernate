package com.bunny.DemoHib;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {

		/*
		 * Code for Student1
		 * 
		 */

		Configuration config = new Configuration().configure().addAnnotatedClass(Student1.class);

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();

		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();
		session.beginTransaction();
		/*
		 * 
		 * 
		 * Using HQL(Hibernate Query Language)
		 * 
		 */

//		Query q = session.createQuery("from Student1 where marks > 50");
//		List<Student1> students = q.list();
//		for (Student1 s : students) {
//			System.out.println(s);
//		}

//		Query q = session.createQuery("select rollno,name,marks from Student1");
//		Object[] student = (Object[]) q.uniqueResult();
//		for (Object o : student) {
//			System.out.println(o);
//		}

		Query q = session.createQuery("select sum(marks) from Student1 where marks > 80");
		List<Object[]> student = (List<Object[]>) q.list();
		for (Object[] o : student) {
			System.out.println(o[0] + ":" + o[1] + ":" + o[2]);
		}
//		Random r = new Random();
//		for (int i = 1; i <= 50; i++) {
//			Student1 s = new Student1();
//			s.setRollno(i);
//			s.setName("Name " + i);
//			s.setMarks(r.nextInt(100));
//			session.save(s);
//		}

		session.getTransaction().commit();

		/*
		 * Code for student
		 * 
		 */
//		Laptop laptop = new Laptop();
//		laptop.setLid(101);
//		laptop.setLname("HP");
//
//		Student s = new Student();
//		s.setRollno(1);
//		s.setName("Saurabh");
//		s.setMarks(90);
//		s.getLaptop().add(laptop);
//		laptop.getStudent().add(s);
//
//		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
//				.addAnnotatedClass(Laptop.class);
//
//		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
//				.build();
//
//		SessionFactory sf = config.buildSessionFactory(registry);
//
//		Session session1 = sf.openSession();
//
//		session1.beginTransaction();
//		session1.save(laptop);
//		session1.save(s);
//
//		
//		Query<Laptop> query1 = session1.createQuery("from Laptop where lid = :id", Laptop.class);
//		query1.setParameter("id", 101);
//		query1.setCacheable(true);
//		Laptop o1 = query1.uniqueResult(); // Triggers SELECT
//		System.out.println(o1);
//		session1.getTransaction().commit();
//		session1.close();
//		
//		
//		Session session2 = sf.openSession();
//		session2.beginTransaction();
//		Query<Laptop> query2 = session2.createQuery("from Laptop where lid = :id", Laptop.class);
//		query2.setParameter("id", 101);
//		query2.setCacheable(true);
//
//		Laptop o2 = query2.uniqueResult(); // Triggers SELECT
//		System.out.println(o2);
//		session1.getTransaction().commit();
//		session1.close();

		/*
		 * Code for TName Class
		 */

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
