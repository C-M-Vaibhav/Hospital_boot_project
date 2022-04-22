package com.ty.hospital.hospitalappboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.ty.hospital.hospitalappboot.dto.Person;

@RestController
public class PersonController {

	@Autowired
	PersonService service;

	@ApiOperation(value = "save the details of Person",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Person saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@PostMapping("/person")
	public Person saveperson(@RequestBody Person person) {
		return service.savePerson(person);
	}

	@ApiOperation(value = "Got Person Object",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got Person object"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@PostMapping("/personobj")
	public Person getPerson() {
		return new Person();
	}

	@ApiOperation(value = "Got the details of Person by id",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Person Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@GetMapping("/person")
	public Person person(@RequestParam int id) {
		return service.getByPersonId(id);
	}

	@ApiOperation(value = "Got the details of AllPersons",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "AllPersons details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@GetMapping("/getAllPerson")
	public List<Person> allPerson() {
		return service.getAllPersons();
	}

	@ApiOperation(value = "Deleted the details of Person",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Person Deleted"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@DeleteMapping("/person")
	public String deletePerson(@RequestParam int id) {
		service.deletePersonById(id);
		return "Given Id is deleted";
	
	}

	@ApiOperation(value = "Updated the details of Person",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Person Updated"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@PutMapping("/person")
	public Person updatePerson(@RequestParam int id,@RequestBody Person person) {
		return service.updatePersonById(id, person);
	}
}
