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

import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.service.EncounterService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {

	@Autowired
	private EncounterService service;

	@ApiOperation(value = "save the details of Encounter",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Encounter saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper Encounter data")
	})
	@PostMapping("/branch/{b_id}/person/{p_id}/encounter")
	public Encounter saveEncounter(@PathVariable(name = "b_id") int b_id, @PathVariable(name = "p_id") int p_id,
			@RequestBody Encounter encounter) {
		return service.saveEncounter(b_id, p_id, encounter);
	}
	
	@ApiOperation(value = "save the details of Encounter",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Encounter saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper Encounter data")
	})
	@PostMapping("/encount")
	public Encounter get() {
		return new Encounter();
	}

	@ApiOperation(value = "all the details of AllEncounters from Person Id",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got all Encounters"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@GetMapping("/person/{id}/encounter")
	public List<Encounter> getEncounterByPersonId(@PathVariable int id) {
		return service.getAllEncountersByPersonId(id);
	}

	@ApiOperation(value = "all the details of AllEncounters from Branch Id",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got all Encounters"),
		@ApiResponse(code = 405,message = "Bad request, not proper Branch data")
	})
	@GetMapping("/branch/{id}/encounter")
	public List<Encounter> getEncounterByBranchId(@PathVariable int id) {
		return service.getAllEncountersByBranchId(id);
	}

	@ApiOperation(value = "Updated the details of Encounter",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Encounter Updated"),
		@ApiResponse(code = 405,message = "Bad request, not proper Encounter data")
	})
	@PutMapping("/encounter")
	public Encounter updateEncounter(@RequestParam int id,@RequestBody Encounter encounter) {
		return service.updateEncounter(id, encounter);
	}

	@ApiOperation(value = "Deleted the details of Encounter",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Encounter Deleted"),
		@ApiResponse(code = 405,message = "Bad request, not proper Encounter data")
	})
	@DeleteMapping("/encounter")
	public boolean deleteEncounterById(@RequestParam int id) {
		return service.deleteEncounterById(id);
	}

}
