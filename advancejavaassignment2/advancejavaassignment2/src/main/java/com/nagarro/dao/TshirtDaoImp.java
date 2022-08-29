package com.nagarro.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.TShirt;



public class TshirtDaoImp {

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
	
	public void saveData(TShirt tshirt)
	{
		session.save(tshirt);
	}
	
	public void commitSession() {
		
		session.getTransaction().commit();
		
	}
	
	
	public List<TShirt> getSessionWithoutTransaction(String color,String size,String gender) {
		
		if(!session.isOpen())
		{
			session = factory.openSession();
		}
		
		Criteria criteria = session.createCriteria(TShirt.class);
		criteria.add(Restrictions.eq("color", color));
		criteria.add(Restrictions.eq("size", size));
		criteria.add(Restrictions.eq("gender", gender));
		criteria.add(Restrictions.eq("availability", "Y"));
		List<TShirt> list = criteria.list();
		return list;
	}
	
	public void closeSession() {
		session.close();
	}
	
}
