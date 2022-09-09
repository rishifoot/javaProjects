package com.nagarro.util;





import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.User;

public class Util {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			try {
				sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
				return sessionFactory;
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}
