package com.servlet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.servlet.model.Student;;

public class DBData {

	public List<Student> getStudentList() {

		List<Student> studentList = new ArrayList<>();

		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();

		return studentList= session.createQuery(" from Student").list();
		

		

	}

	public void addStudent(Student student) {
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.save(student);
		t.commit();
		System.out.println("inserted.......");
	}

	public void updateStudent(Student student) {
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.update(student);
		t.commit();
		System.out.println("updated....");
	}

	public void deleteStudent(Student student) {
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.delete(student);
		t.commit();
		System.out.println("deleted....");
	}
	
	public Student getStudentById(int id){
		
		String query = "from Student s where s.studentId =" + id;
		
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Query query2 = session.createQuery(query);
		
		Student student= (Student) query2.list().get(0);
		
		return student;
	}
	
}
