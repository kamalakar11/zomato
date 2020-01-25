package com.example.delegate;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.Food;

@Service
public class FoodOrderDelegate {

	@Autowired
	private FoodOrderDao dao;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public void placeOrder(Food food) {
		System.out.println("placeOrder :: FoodOrderDelegate");
		dao.save(food);
	}
	
	public Food getOrder(String itemName) {
		System.out.println("getOrder :: FoodOrderDelegate");
		Optional<Food> foodData = dao.findById(itemName);
		return foodData.orElseGet(()->new Food());
	}

	public List<Food> getMenu() {
		System.out.println("getMenu :: FoodOrderDelegate");
		List<Food> foodList = (List<Food>) dao.findAll();
		return foodList;
	}

	public void deleteItem(String itemName) {
		System.out.println("deleteItem :: FoodOrderDelegate");
		dao.deleteById(itemName);
	}

	public List<Food> getFoodList(String itemType) {
		
		SessionFactory sf = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sf.openSession();
		Query q = session.createQuery("from Food where type=:itemType");
		q.setParameter("itemType", itemType);
		System.out.println("query preparation done!!");
		List<Food> list = q.list();
		return list;
	}
}
