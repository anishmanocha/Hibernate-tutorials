package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		try {
			Employee employee= new Employee("Anish", "Manocha", "PNC");
			
			session.beginTransaction();
			
			session.save(employee);
			
			session.getTransaction().commit();
			
			System.out.println("Employee has been added");
			
		}
		
		finally {
			
			factory.close();
		}
		
	

	}

}
