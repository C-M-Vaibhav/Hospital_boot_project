package com.ty.hospital.hospitalappboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.service.Medorderservice;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.ty.hospital.hospitalappboot.dto.Medorder;
import com.ty.hospital.hospitalappboot.service.Medorderservice;

@RestController
public class MedorderController {
	
	@Autowired
	Medorderservice service;
	
	@ApiOperation(value = "save the details of Medorder",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Medorder saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper Medorder data")
	})
	@PostMapping("/encounter/{e_id}/medorder")
	public Medorder saveMedorder(@PathVariable(name="e_id") int e_id,@RequestBody Medorder medorder) {
		return service.saveMedorder(e_id, medorder);
	}
	
	@ApiOperation(value = "Got the Medorder Object",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Medorder Object"),
		@ApiResponse(code = 405,message = "Bad request, not proper Medorder data")
	})
	@PostMapping("/e_hii")
	public Medorder get() {
		return new Medorder();
	}
	
	@ApiOperation(value = "get the details of MedorderById",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Medorder Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Medorder data")
	})
	@GetMapping("/medorder")
	public Medorder getMedorderById(@RequestParam int id) {
		return service.getMedorderByid(id);
	}
	
	@ApiOperation(value = "save the details of Medorder",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Medorder saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper Medorder data")
	})
	@GetMapping("encounter/{e_id}/medorder")
	public List<Medorder> getMedordersByEncounterId(@PathVariable(value = "e_id") int e_id){
		return service.getMedordersByEncounterId(e_id);
	}
	
	@ApiOperation(value = "Deleted the details of Medorder",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Medorder Deleted"),
		@ApiResponse(code = 405,message = "Bad request, not proper Medorder data")
	})
	@DeleteMapping("/medorder")
	public boolean deleteMedorder(@RequestParam int id) {
		return service.deleteMedorderById(id);
	}
	
	@ApiOperation(value = "Updated the details of Medorder",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Medorder updated"),
		@ApiResponse(code = 405,message = "Bad request, not proper Medorder data")
	})
	@PutMapping("/medorder")
	public Medorder updateMedorder(int id,Medorder medorder) {
		return service.updateMedorder(id, medorder);
	}

}
