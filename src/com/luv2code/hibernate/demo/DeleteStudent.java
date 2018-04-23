package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		
		/* This here demonstrates the difference between a bulk and a selective update*/
		
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		
		try {
			int studentId=1;
			
			session.beginTransaction();
			
			Student studentToDelete=session.get(Student.class, studentId);
				
			session.delete(studentToDelete);
			
			System.out.println("Done");
			
			session.createQuery("Delete Student where lastName='First' ").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		
		finally {
			
			factory.close();
		}
		
	}

}
