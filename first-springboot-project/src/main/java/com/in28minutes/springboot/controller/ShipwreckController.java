package com.in28minutes.springboot.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.model.Shipwreck;
import com.in28minutes.springboot.service.ShipwreckRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/shipwrecks")
public class ShipwreckController {
	@Autowired
	ShipwreckRepository swr;
	
	@GetMapping()
	public Iterable<Shipwreck> getAllShipwrecks(){
	return swr.findAll();
	}
	@GetMapping("/{id}")
	public Shipwreck getShipwreck(@PathVariable("id") long id){
	return swr.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
	@PostMapping("")
	public Shipwreck create( @RequestBody Shipwreck wreck) {
	return swr.save(wreck);
	}
	@PutMapping("/{id}")
	public Shipwreck updateShipwreck(@PathVariable("id") long id,
			@RequestBody Shipwreck wreck){
	Shipwreck existingwreck 
	= swr.findById(id).orElseThrow(() -> new EntityNotFoundException());
	System.out.println("shipwreck " +  wreck );
	BeanUtils.copyProperties(wreck, existingwreck);
	swr.save(existingwreck);
	return wreck;
	}
	@DeleteMapping("/{id}")
	public String deleteShipwreck(@PathVariable("id") long id){
	Shipwreck wreck = swr.findById(id).orElseThrow(()
			-> new EntityNotFoundException());
	swr.delete(wreck);
	return "Deleted Successfully!";
	}
	
	@GetMapping("/full")
	public @ResponseBody List<Shipwreck> list() {
        return swr.findAll();
    }
	
	public static void main(String[] args) {
		System.out.println("######BeanUtils.copyProperties(wreck, existingwreck)##############");
		System.out.println("--------------------------------------------------------------");
		Shipwreck wreck =new Shipwreck(1l, "name1", "description1", "condition1", 33, 55.00, 66.23, 2018);
		Shipwreck existingwreck =new Shipwreck(2l, "name2", "description2", "condition2", 19, 45.00, 46.23, 2015);
		System.out.println("BEFORE:: "
				+ "existingwreck= "+existingwreck.getName()
				+"--wreck ="+wreck.getName());
		BeanUtils.copyProperties(wreck, existingwreck);
		System.out.println("AFTER:: "
				+ "existingwreck= "+existingwreck.getName()
				+"--wreck ="+wreck.getName());
}
	

//@CrossOrigin(origins= "http://loalhost:3000")
/*@ApiOperation(value="Get All Shipwrecks ", notes="Get All Shipwrecks" )
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Server Error")
})*/
}