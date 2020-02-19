package com.revature.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Food;

/*
 *	Jackson is a Java dependency for JSON.  Jackson can be used in a lot of different
 * fashions, but includes the functionality of reading input streams directly into
 * Java objects, and reading Java objects directly into output streams.  This is
 * very useful, because those are the types our servlets rely on.
 * 
 * Important Note: Jackson ASSUMES your classes have constructors and getters/setters.
 * If you do not have these things, it will not work - sometimes failing silently. 
 * 
 * Marshalling/Unmarshalling - Language often used with Jackson/JSON
 * Marshalling is the process of creating JSON from a Java Object
 * Unmarshalling is the process of creating a Java Object from JSON
 */
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Map<Integer, Food> foodMap = new HashMap<>();
    int counter = 0;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  food/<int>
		String[] parts = request.getPathInfo().split("/");
		
		if (parts.length < 1) {
			response.setStatus(400);
			return;
		}
		
		String part = parts[1];
		int id = 0;
		try {
			id = Integer.parseInt(part);
		} catch(NumberFormatException e) {
			response.setStatus(400);
			return;
		}
		
		Optional<Food> optionalFood = Optional.ofNullable(foodMap.get(id));
		
		if (!optionalFood.isPresent()) {
			response.setStatus(404);
			return;
		}
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), optionalFood.get());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		
		// Using Jackson to create object from JSON
		Food food = om.readValue(request.getReader(), Food.class);
		
		// Stuff that should probably be happening in the service/DAO
		food.setId(++counter);
		foodMap.put(food.getId(), food);
		
		response.setStatus(201);
		response.setContentType("application/json");
		
		// Using Jackson to create JSON from object
		om.writeValue(response.getWriter(), food);
	}

}
