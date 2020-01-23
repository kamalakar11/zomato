package com.example.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.Food;

@Service
public class FoodOrderDelegate {

	@Autowired
	private FoodOrderDao dao;
	
	public void placeOrder(Food food) {
		System.out.println("placeOrder :: FoodOrderDelegate");
		dao.save(food);
	}
}
