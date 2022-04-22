package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.Exception.NoFoundByIdException;
import com.ty.hospital.hospitalappboot.dao.HospitalDao;
import com.ty.hospital.hospitalappboot.dto.Hospital;

@Service
public class HospitalService {
	
	@Autowired
	HospitalDao dao ;
	
	public Hospital saveHospital(Hospital hospital) {
		return dao.saveHospital(hospital);
	}
	public Hospital updateHospital(int h_id,Hospital hospital) {
		Hospital h = dao.updateHospital(h_id, hospital);
		if(h==null) {
			throw new NoFoundByIdException();
		}else {
			return h;
		}

	}
	public boolean deleteHospital(int id) {
		 if(dao.deleteHospitalById(id)!=true) {
			 throw new NoFoundByIdException();
		 }
		 return true;
		 
	}
	public List<Hospital> getHospitals(){
		List<Hospital> hospitals = dao.allHospital();
		if(hospitals==null) {
			throw new NoFoundByIdException();
		}else {
			return hospitals;
		}
	}
	
	public Hospital getHospitalById(int id) {
		Hospital hospital = dao.getHospitalById(id);
		if(hospital==null) {
			throw new NoFoundByIdException();
		}
		return hospital;
	}
}
