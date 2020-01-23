package com.example.delegate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.Food;

@Repository
public interface FoodOrderDao extends CrudRepository<Food, String> {

}
