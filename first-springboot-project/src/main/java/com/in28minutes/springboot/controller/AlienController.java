package com.in28minutes.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.model.Alien;
import com.in28minutes.springboot.service.AlienRepo;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo alrepo;
	
	@GetMapping("/")
	public String name() {
		return "home.jsp";
	}
	
	@GetMapping("/addAlien")
	public String saveData(Alien alien) {
		alrepo.save(alien);
		return "/home.jsp";
	}
	

}
