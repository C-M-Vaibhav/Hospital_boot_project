package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.Exception.NoFoundByIdException;
import com.ty.hospital.hospitalappboot.dao.EncounterDao;
import com.ty.hospital.hospitalappboot.dto.Encounter;

@Service
public class EncounterService {

	@Autowired
	EncounterDao dao;

	public Encounter saveEncounter(int b_id, int p_id, Encounter encounter) {
		Encounter e = dao.saveEncounter(b_id, p_id, encounter);
		if(e==null) {
			throw new NoFoundByIdException();
		}
		return e;
	}

	public Encounter updateEncounter(int id, Encounter encounter) {
		Encounter e = dao.updateEncouter(id, encounter);
		if(e==null) {
			throw new NoFoundByIdException();
		}else {
			return e;
		}
	}

	public List<Encounter> getAllEncountersByPersonId(int p_id) {
		List<Encounter> encounters =  dao.getAllEncountersByPersonId(p_id);
		if(encounters.isEmpty()) {
			throw new NoFoundByIdException();
		}
			return encounters;
	}

	public List<Encounter> getAllEncountersByBranchId(int b_id) {
		List<Encounter> encounters =  dao.getAllEncountersByBranchId(b_id);
		if(encounters.isEmpty()) {
			throw new NoFoundByIdException();
		}else {
			return encounters;
		}

	}
	
	public boolean deleteEncounterById(int id) {
		boolean b = dao.deleteEncounterById(id);
		if(b==false) {
			throw new NoFoundByIdException();
		}
		return true;
	}

}
