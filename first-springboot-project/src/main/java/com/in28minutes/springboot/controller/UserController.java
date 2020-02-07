package com.in28minutes.springboot.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.model.User1;
import com.in28minutes.springboot.model.UserException;



@RestController
public class UserController {
	
	List<User1> users= new ArrayList<>();
	User1 user= new User1("abc@co.com", "rabi", "pswd");
	
	@GetMapping("/users")
	public List<User1> getAllUser(){
		users.add(user);
		return users;
	}
	/**
	 * To get specific User from List 
	 * @param username2
	 * @return
	 */
	/*@GetMapping("/users/{username}")
	public List<User> getAllUserByName(
			@PathVariable("username")String username2){
		
		
		List<User> result = users.stream()                
                .filter(record ->
                username2.equals(record.getUserName()))     
                .collect(Collectors.toList());  
		
		return result;
	}*/
	/**
	 * Exception Handle for Specific User
	 * Wrong User search- NOT_FOUND(404
	 * Correct User-      OK(200
	 * @param username2
	 * @return
	 */
	@GetMapping("/users/{username}")
	public <T> ResponseEntity<T> getAllUserByName(
			@PathVariable("username")String username2){
		
		User1 newUser=null;
		List<User1> newUserList = users.stream()                
                .filter(record ->
                username2.equals(record.getUserName()))     
                .collect(Collectors.toList()); 
		if(!newUserList.isEmpty()) {
			newUser= newUserList.get(0);
		}
		if(null != newUser) {
			//OK(200, "OK"),
			return (ResponseEntity)ResponseEntity.ok(newUser);
		}
		else {
			//NOT_FOUND(404, "Not Found"),
			return (ResponseEntity)ResponseEntity.notFound().build();
		}
		
	}
	/**
	 * M-2 Without Proper Exception Handling
	 * @param username2
	 * @return
	 */
	
	@GetMapping("/users2/{username}")
	public User1 getAllUserByName2(@PathVariable("username")String username2) {
		
		User1 newUser=null;
		List<User1> newUserList = users.stream()                
                .filter(record ->
                username2.equals(record.getUserName()))     
                .collect(Collectors.toList()); 
		if(!newUserList.isEmpty()) {
			newUser= newUserList.get(0);
		}
		if(null != newUser) {
			return newUser;
		}
		else {
			throw new ValidationException("WRONG-- INVALID user!!!!!");
		}
		
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> 
	handleValidationError(ValidationException ve){
		return new ResponseEntity<String>(ve.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * M-3 Custom Exception Handling
	 * @param username2
	 * @return
	 */
	/**
	 * List<User1> users= new ArrayList<>();
		User1 user= new User1("abc@co.com", "rabi", "pswd");
	 * @return
	 */
	@GetMapping("/users3")
	public List<User1> getAllUser3(){
		users.add(user);
		return users;
	}
	
	@GetMapping("/users3/{username}")
	public User1 getAllUserByName3(
			@PathVariable("username")String username2)
					throws UserException {
		
		User1 newUser=null;
		List<User1> newUserList = users.stream()                
                .filter(record ->
                username2.equals(record.getUserName()))     
                .collect(Collectors.toList()); 
		if(!newUserList.isEmpty()) {
			newUser= newUserList.get(0);
		}
		if(null != newUser) {
			return newUser;
		}
		else {
			throw new UserException();
		}
		
	}
	
	
	
	
	@GetMapping("*")
	public String fallback() throws Exception{
		throw new Exception();
		
	}
	
	
	
	
	/*
	 * NOT REQUIRED produces/consumes......
	@GetMapping(value= {"/users2"}
	,produces= {"application/JSON","application/XML"})
	public List<User> getAllUser2() {
		users.add(user);
		return users;
	}
	*/
	
	/**
	 * M-1 Without Exception Handling
	 * RequestBody= Convert MODEL-->JSON
	 * @param user2
	 * @return
	 */
	@PostMapping("/usersPost1")
	@ResponseStatus(HttpStatus.CREATED)
	public List<User1> userSignUp1(
			@RequestBody User1 user2){
		users.add(user2);
		return users;
	}
	
	
	
	/**
	 * @VALID
	 * M-1A  Exception Handling -Spring Bean Constraint
	 * RequestBody= Convert MODEL-->JSON
	 * @param user2
	 * @return
	 */
	@PostMapping("/usersPost1A")
	@ResponseStatus(HttpStatus.CREATED)
	public List<User1> userSignUp1A(
			@RequestBody @Valid User1 user2){
		users.add(user2);
		return users;
	}
	
	
	
	/**
	 * M-2 With Exception Handling using @ExceptionHandler
	 * RequestBody= Convert MODEL-->JSON
	 * @param user2
	 * @return
	 */
	@PostMapping("/usersPost2")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User1> userSignUp2(
			@RequestBody User1 user2){
		String urlStr="/usersPost2/user2";
		String ERROR_EMAIL="User can not be created -Email is NULL!!!";
		URI location =URI.create(urlStr);
		
		if(null!=user2.getEmail()) {
			users.add(user2); //It will save into Collection
			return ResponseEntity.created(location).body(user2);
		}
		else{
			throw new ValidationException(ERROR_EMAIL);
		}
		
		/*users.add(user2);
		return users;*/
	}
	
	
	
	
	/**
	 * PUT-Without Exception
	 * PUT -->Not create object several times
	 * @param user2
	 * @return
	 */
	@PutMapping("/usersPut1")
	@ResponseStatus(HttpStatus.CREATED)
	public List<User1> signUpUserPut1(
			@RequestBody User1 user2){
		users.add(user2);
		return users;
	}
	
	
	/**
	 * PUT-With Exception
	 * @return
	 */
	@PutMapping("/usersPut2")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User1> signUpUserPut2(
			@RequestBody User1 user2) throws Exception{

		String urlStr="/usersPost2/user2";
		String ERROR_NAME="UserName can not be created -Name is NULL!!!";
		URI location =URI.create(urlStr);
		
		if(null!=user2.getUserName()) {
			users.add(user2); //It will save into Collection
			return ResponseEntity.created(location).body(user2);
		}
		else{
			throw new NullPointerException(ERROR_NAME);
		}
		
		/*users.add(user2);
		return users;*/
	}
	//FORBIDDEN(403, "Forbidden"),
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> 
	handleError(NullPointerException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.FORBIDDEN);
	}
	

}
