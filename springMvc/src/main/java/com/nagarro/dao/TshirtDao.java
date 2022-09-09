package com.nagarro.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Tshirt;
@Component
public class TshirtDao {
	private static SessionFactory factory;
	private static Session session;
	
	public void getSessionWithTransaction() {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = factory.openSession();
	}
	
	public void beginTransaction()
	{
        session.beginTransaction();
	}
	
	public Session getCurrentSession()
	{
		return session;
	}
	
	public void saveData(Tshirt tshirt)
	{
		session.save(tshirt);
	}
	
	public void commitSession() {
		
		session.getTransaction().commit();
		
	}
	
	
	public List<Tshirt> getSessionWithoutTransaction(String color,String size,String gender) {
		
//		if(!session.isOpen())
//		{
//			session = factory.openSession();
//		}
		
		Criteria criteria = session.createCriteria(Tshirt.class);
		criteria.add(Restrictions.eq("color", color));
		criteria.add(Restrictions.eq("size", size));
		criteria.add(Restrictions.eq("gender", gender));
		criteria.add(Restrictions.eq("availability", "Y"));
		List<Tshirt> list = criteria.list();
		return list;
	}
	
	public void closeSession() {
		session.close();
	}
	
}
