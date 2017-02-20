package com.restExample.org;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.lang.ArithmeticException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;

@RestController
public class WelcomeController {

	private static final String CALCULATOR_TEMPLATE = "The calculated value is, %s";

	private static final String TEMPLATE = "Hi, %s";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Welcome greeting(@RequestParam(value = "name", defaultValue = "User") String name) {
		return new Welcome(counter.incrementAndGet(), String.format(TEMPLATE, name));
	}

	@RequestMapping("/calculate")
	public String Calculator(@RequestParam String requestParams) throws JsonParseException, IOException{
		Map<String, String> map = new HashMap<>();
		JSONObject jObject = new JSONObject(requestParams);
		Iterator<?> keys = jObject.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String value = jObject.getString(key);
			map.put(key, value);
		}

		int a = Integer.parseInt(map.get("a"));
		int b = Integer.parseInt(map.get("b"));
		String operator = map.get("operator");
		int value = calculateValue(a, b, operator);
		if(value == Integer.MAX_VALUE){
			return  String.format("Divide by zero error. Please check your input");
		}
		
		
		
		return  String.format(CALCULATOR_TEMPLATE, value);
	}

	public int calculateValue(int a, int b, String operator){
		switch (operator) {
		case "addition":
			return a + b;
		case "subtraction":
			return a - b;
		case "multiplication":
			return a * b;
		case "division":
			try{
				return a / b;	
			}catch(ArithmeticException e){
				return Integer.MAX_VALUE;
			}
			
		default:
			return -1;

		}

	}

}