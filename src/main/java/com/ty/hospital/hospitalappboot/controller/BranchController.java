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

import com.ty.hospital.hospitalappboot.dao.BranchDao;
import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.service.BranchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {
	
	@Autowired
	BranchService service;
	
	@ApiOperation(value = "save the details of Branch",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Branch saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper Branch data")
	})
	@PostMapping("/hospital/{h_id}/branch")
	public Branch saveBranch(@PathVariable int h_id,@RequestBody Branch branch) {
		return service.saveBranch(h_id, branch);
		
	}
	
	@ApiOperation(value = "To Get Branch object",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got Branch Object"),
		@ApiResponse(code = 405,message = "Bad request, not proper Branch data")
	})
	@PostMapping("/hi")
	public Branch get() {
		return new Branch();
	}
	
	@ApiOperation(value = "Get the details of Branch",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Branch Got"),
		@ApiResponse(code = 405,message = "Bad request, not proper Branch data")
	})
	@GetMapping("/branch")
	public List<Branch> getBranchs(@RequestParam int id){
		return service.allBranchsByHospitalId(id);
	}
	
	@ApiOperation(value = "All the details of Hospital",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "All Hospitals"),
		@ApiResponse(code = 405,message = "Bad request, not proper Hospital data")
	})
	@PutMapping("/updatebranch")
	public Branch updateBranchById(@RequestParam int id,@RequestBody Branch branch) {
		return service.updateBranch(id, branch);
	}
	
	@ApiOperation(value = "deleted the details of Hospital",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Hospital Deleted"),
		@ApiResponse(code = 405,message = "Bad request, not proper Hospital data")
	})
	@DeleteMapping("/deletebranch")
	public boolean deleteBranchById(@RequestParam int id) {
		return service.deleteBranchById(id);
	}


}
