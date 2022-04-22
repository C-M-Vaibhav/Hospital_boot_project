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

import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.service.HospitalService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {
	
	@Autowired
	HospitalService service;
	
	@ApiOperation(value = "save the details of Hospital",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Hospital saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper Hospital data")
	})
	@PostMapping("/hospital")
	public Hospital insert(@RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}
	
	@ApiOperation(value = "To Get Hospital object",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got Hospital Object"),
		@ApiResponse(code = 405,message = "Bad request, not proper Hospital data")
	})
	@PostMapping("/gethospital")
	public Hospital getHospital() {
		return new Hospital();
	}
	
	@ApiOperation(value = "Get the details of Hospital",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Hospital Got"),
		@ApiResponse(code = 405,message = "Bad request, not proper Hospital data")
	})
	@GetMapping("/hospital")
	public Hospital getHospital(@RequestParam int id) {
		return service.getHospitalById(id);
	}
	
	@ApiOperation(value = "All the details of Hospital",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "All Hospitals"),
		@ApiResponse(code = 405,message = "Bad request, not proper Hospital data")
	})
	@GetMapping("/allhospital")
	public List<Hospital> getHospitals(){
		return service.getHospitals();
	}
	
	@ApiOperation(value = "deleted the details of Hospital",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Hospital Deleted"),
		@ApiResponse(code = 405,message = "Bad request, not proper Hospital data")
	})
	@DeleteMapping("/hospital")
	public boolean deleteHospital(@RequestParam int id) {
		return service.deleteHospital(id);
	}

	@ApiOperation(value = "Updated the details of Hospital",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Hospital Updated"),
		@ApiResponse(code = 405,message = "Bad request, not proper Hospital data")
	})
	@PutMapping("/hospital")
	public Hospital updateHospital(@RequestParam int id,@RequestBody Hospital hospital) {
		return service.updateHospital(id, hospital);
	}
}
