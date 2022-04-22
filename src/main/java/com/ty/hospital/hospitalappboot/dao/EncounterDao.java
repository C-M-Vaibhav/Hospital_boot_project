package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.repositary.EncounterRepositary;

@Repository
public class EncounterDao {

	@Autowired
	EncounterRepositary Repositary;

	@Autowired
	PersonDao personDao;

	@Autowired
	BranchDao branchDao;

	public Encounter saveEncounter(int b_id, int p_id, Encounter encounter) {
		Branch branch = branchDao.getBranchById(b_id);
		Person person = personDao.getPersonById(p_id);
		if (branch != null && person != null) {
			encounter.setBranchs(branch);
			encounter.setPerson(person);
			return Repositary.save(encounter);

		}
		return null;
	}

	public Encounter getEncounterById(int id) {
		Optional<Encounter> opt = Repositary.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	public boolean deleteEncounterById(int id) {
		Encounter encounter = getEncounterById(id);
		if (encounter != null) {
			Repositary.delete(encounter);
			return true;
		}
		return false;
	}

	public Encounter updateEncouter(int id, Encounter encounter) {
		Encounter e = getEncounterById(id);
		if (e != null) {
			return Repositary.save(encounter);
		}
		return null;
	}

	public List<Encounter> getAllEncountersByPersonId(int p_id) {
		return Repositary.getAllEncountersByPersonId(p_id);
	}

	public List<Encounter> getAllEncountersByBranchId(int b_id) {
		return Repositary.getAllEncountersByBranchId(b_id);
	}

}
