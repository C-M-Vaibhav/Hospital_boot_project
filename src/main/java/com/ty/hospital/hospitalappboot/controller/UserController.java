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

import com.ty.hospital.hospitalappboot.dto.User;
import com.ty.hospital.hospitalappboot.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@ApiOperation(value = "save the details of User",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "User saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data")
	})
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@ApiOperation(value = "get the object of User",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "User Object got"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data")
	})
	@PostMapping("/userobj")
	public User getUser() {
		return new User();
	}
	
	@ApiOperation(value = "ALl the details of Users",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "All Users"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data")
	})
	@PostMapping("/alluser")
	public List<User> getall() {
		return service.getAllUser();
	}

	@ApiOperation(value = "got the details of Particular User",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "User Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data")
	})
	@GetMapping("/user")
	public User geUserById(@RequestParam int id) {
		return service.getUserById(id);
	}
	
	@ApiOperation(value = "Deleted the User",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "User Deleted"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data")
	})
	@DeleteMapping("/user")
	public boolean deleteUser(@RequestParam int id) {
		return service.deleteUserById(id);
	}
	
	@ApiOperation(value = "updated the details of User",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "User Updated"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data")
	})
	@PutMapping("/user")
	public User updateUser(@RequestParam int id, @RequestBody User user) {
		return service.updateUserById(id, user);
	}

}
