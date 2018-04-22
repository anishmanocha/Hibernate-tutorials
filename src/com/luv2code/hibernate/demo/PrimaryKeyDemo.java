package com.luv2code.hibernate.demo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
	/*Didn't feel this was necessary, because it seems to me the autoincrement without
	the appropriate annotation still works just fine*/

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session= factory.getCurrentSession();


		try {
			
			ArrayList<Student> listOfStudents= new ArrayList<Student>();
			
			Student student= new Student("First", "First", "firstfirst@gmail.com");
			Student otherStudent= new Student("Second", "Second", "secondsecond@gmail.com");
			
			listOfStudents.add(student);
			listOfStudents.add(otherStudent);
			
			
				session.beginTransaction();

				session.save(student);
				
				session.save(otherStudent);

				session.getTransaction().commit();
				
				System.out.println("Done");
				
			
			
			

			

		}

		finally {

			factory.close();
		}

	}

}
