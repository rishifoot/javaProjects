package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.nagarro.model.User;
import com.nagarro.util.Util;

@Component
public class UserDao {
	
	public boolean isValid(String username,String password) {
		System.out.println("hfdhfdkj");
		Transaction transaction=null;
		User user=null;
		Session session=Util.getSessionFactory().openSession();
		transaction=session.beginTransaction();
		user=(User)session.createQuery("from User U WHERE U.username=:username").setParameter("username",username).uniqueResult();
		
	if(user!=null&&user.getPassword().equals(password)) {
		return true;
	}
	transaction.commit();
	return false;
	
	}

}
