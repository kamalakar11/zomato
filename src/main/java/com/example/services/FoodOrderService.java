package com.example.services;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.delegate.FoodOrderDelegate;
import com.example.pojo.Food;

@RestController
public class FoodOrderService {

	@Autowired
	private FoodOrderDelegate delegate;

	@RequestMapping(value = "/placeOrder", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public String placeOrder(@RequestBody Food food) {
		System.out.println(food.getItemName());
		System.out.println(food.getPrice());
		delegate.placeOrder(food);
		return "succesfully placed order";
	}

	@RequestMapping(value = "/getOrder/{item}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public Food getOrder(@PathVariable("item") String itemName) {
		System.out.println("getOrder::FoodOrderServices");
		System.out.println("Item requested for : " + itemName);
		Food food = delegate.getOrder(itemName);

		return food;
	}

	@RequestMapping(value = "/getMenu", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public List<Food> getMenu() {
		System.out.println("getMenu::FoodOrderServices");
		List<Food> foodList = delegate.getMenu();
		return foodList;
	}

	@RequestMapping(value="/deleteItem/{item}", method = RequestMethod.DELETE)
	public String deleteItem(@PathVariable("item") String itemName) {
		System.out.println("deleteItem :: FoodOrderServices");
		delegate.deleteItem(itemName);
		return "successfully deleted " + itemName;
	}
	
	@RequestMapping(value="/getFoodList/{type}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public List<Food> getFoodListByType(@PathVariable("type") String itemType) {
		System.out.println("getFoodsByType :: FoodOrderServices");
		List<Food> foodList = delegate.getFoodList(itemType);
		return foodList;
	}

	/*
	 * @RequestMapping(value="/placeOrderXml", consumes =
	 * MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST) public String
	 * placeOrderXml(@RequestBody Food food) {
	 * System.out.println(food.getItemName()); System.out.println(food.getPrice());
	 * return "succesfully placed order"; }
	 */
}
