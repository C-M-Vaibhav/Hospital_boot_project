package com.ty.hospital.hospitalappboot.dao;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.repositary.HospitalReapositary;

@Repository
public class HospitalDao {
	
	@Autowired
	private HospitalReapositary reapositary;

	public Hospital saveHospital(Hospital hospital) {
		
		List<Branch> branchs = hospital.getBranchs();
		for(Branch branch : branchs) {
			branch.setHospital(hospital);
		}
		return reapositary.save(hospital);
	}
	
	public Hospital getHospitalById(int  id) {
		Optional<Hospital> opt = reapositary.findById(id);
		if(opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}
	
	public Hospital updateHospital(int id,Hospital hospital) {
		Hospital ehospital = getHospitalById(id);
		if(ehospital!=null) {
			return  reapositary.save(hospital);
		}
		return null;
	}
	
	
	/*public Person getPersonById(int id) {
		Optional<Person> opt = reapositary.findById(id);
		return opt.get();
	}*/
	
	public boolean deleteHospitalById(@RequestParam int id) {
		Hospital hospital = getHospitalById(id);
		if(hospital!=null) {
			reapositary.deleteById(id);
			return true;
		}
		return false;
		
	}
	
	public List<Hospital> allHospital(){
		return reapositary.findAll();
	}
	
	

}
