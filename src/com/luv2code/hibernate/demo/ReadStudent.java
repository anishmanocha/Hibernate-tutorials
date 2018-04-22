package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		
		try {
			Student student= new Student("Yuanhao", "Yuanhao", "yuanhaoyuanhao@gmail.com");
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			//New code to read the student from the database
			
			//find out the student's id: primary key
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve student based on primary key
			
			System.out.println("\nGetting student wth id: " + student.getId());
			
			Student myStudent= session.get(Student.class, student.getId());
			
			System.out.println(myStudent);
			
			//commit the transaction
			
			session.getTransaction().commit();
			
		}
		
		finally {
			
			factory.close();
		}
		
	}

}
