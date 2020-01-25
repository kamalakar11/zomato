package com.example.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.pojo.Food;

public class FoodOrderDaoCustomImpl implements IFoodOrderDaoCustom {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<Food> findByType(String itemType) {
		System.out.println("getFoodList :: FoodOrderDaoCustomImpl");
		SessionFactory sf = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sf.openSession();
		Query q = session.createQuery("from Food where type=:itemType");
		q.setParameter("itemType", itemType);
		System.out.println("query preparation done!!");
		List<Food> list = q.list();
		session.close();
		return list;
	}

}
