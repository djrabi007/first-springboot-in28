package com.in28minutes.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	//Auto wiring
	@Autowired
	private WelcomeService service;

	@RequestMapping("/welcome")
	public String welcome() {
		return service.retrieveWelcomeMessage();
	}
	/**
	 * Will give result for "greetings" and "greeting1"
	 * @return
	 */
	@RequestMapping(value= {"/greetings","/greeting1"})
	public String greeting() {
		return "Greeting!!!";
	}
	
	
	
	
	
	
	/**
	 * Use of @PathVariable
	 * @param id1
	 * @return
	 */
	@RequestMapping(value= {"/greetingsPath/{id}"})
	public String greetingPath(
			@PathVariable("id") String id1) {
		return "Greeting!!!"+id1;
	}
	
	/**
	 * Fallback Method
	 */
	@GetMapping(value= {"/greetingsFallback/{id}"})
	public String greetingFallback(
			@PathVariable("id") String id1) {
		return "Greeting Fallback !!!"+id1;
	}
	
	
}