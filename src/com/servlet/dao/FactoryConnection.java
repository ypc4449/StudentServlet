package com.servlet.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class FactoryConnection {
	
	
	private SessionFactory factory = null;
	
	
	public SessionFactory getSessionFactory (){
		
		
		if(this.factory == null){
			Configuration conf = new AnnotationConfiguration().configure();
			this.factory = conf.buildSessionFactory();
		}
		
		return this.factory;
		
	}

}
