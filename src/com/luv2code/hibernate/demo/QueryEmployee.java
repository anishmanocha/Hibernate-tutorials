package com.luv2code.hibernate.demo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class QueryEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			ArrayList<Employee> listOfEmployees= (ArrayList<Employee>) session.createQuery("from Employee where company= 'PNC'").getResultList();
			
			session.getTransaction().commit();
			
			for (int i=0; i<listOfEmployees.size(); i++) {
				
				System.out.println(listOfEmployees.get(i));
			}
			
		}
		
		finally {
			
			factory.close();
		}
		
	

	}

}
