package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		
		try {
			Student student= new Student("Dipali", "Manocha", "dipalimanocha@gmail.com");
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		
		finally {
			
			factory.close();
		}
		
	}

}
