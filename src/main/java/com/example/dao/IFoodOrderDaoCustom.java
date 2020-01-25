package com.example.dao;

import java.util.List;

import com.example.pojo.Food;

public interface IFoodOrderDaoCustom {

	public List<Food> findByType(String itemType);
}
