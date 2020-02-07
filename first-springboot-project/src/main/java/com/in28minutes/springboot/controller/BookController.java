package com.in28minutes.springboot.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.model.BookUser;

@RestController
public class BookController {

	@CrossOrigin("http://localhost:4200")
	@GetMapping("/findAllBookUser")
	public List<BookUser> getBookUser() {

		BookUser bu1 = new BookUser("1", "Rabi Podder", "djrabi007", "r@gg1.com");
		BookUser bu2 = new BookUser("2", "Roddur Podder", "djrabi008", "r@gg2.com");
		BookUser bu3 = new BookUser("3", "Swagata Podder", "djrabi009", "r@gg3.com");
		BookUser bu4 = new BookUser("4", "Ma Podder", "djrabi003", "r@gg4.com");
		BookUser bu5 = new BookUser("5", "Baba Podder", "djrabi003", "r@gg5.com");

		return Stream.of(bu1, bu2, bu3, bu4, bu5).collect(Collectors.toList());

	}

}
