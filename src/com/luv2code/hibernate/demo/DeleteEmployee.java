package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		try {
			int idEmployee=1;
			
			session.beginTransaction();
			
			Employee employeeToBeDeleted= session.get(Employee.class, idEmployee);
			
			session.delete(employeeToBeDeleted);
			
			session.getTransaction().commit();
			
		}
		
		finally {
			
			factory.close();
		}
		
	

	}

}
