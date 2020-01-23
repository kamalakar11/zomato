package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.delegate.FoodOrderDelegate;
import com.example.pojo.Food;

@RestController
public class FoodOrderService {

	@Autowired
	private FoodOrderDelegate delegate;
	
	@RequestMapping(value="/placeOrder",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
	public String placeOrder(@RequestBody Food food) {
		System.out.println(food.getItemName());
		System.out.println(food.getPrice());
		delegate.placeOrder(food);
		return "succesfully placed order";
	}
	
	@RequestMapping(value = "/getOrder", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Food getOrder() {
		System.out.println("getOrder::FoodOrderServices");
		Food food = new Food();
		food.setItemName("Mutton Biryani");
		food.setPrice(450);
		food.setQuantity("Full");
		food.setType("Non-Veg");
		
		return food;
	}
	/*
	 * @RequestMapping(value="/placeOrderXml", consumes =
	 * MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST) public String
	 * placeOrderXml(@RequestBody Food food) {
	 * System.out.println(food.getItemName()); System.out.println(food.getPrice());
	 * return "succesfully placed order"; }
	 */
}
