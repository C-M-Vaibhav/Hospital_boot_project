package com.ty.hospital.hospitalappboot.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.dto.Medorder;

public interface EncounterRepositary extends JpaRepository<Encounter, Integer> {
	@Query("select e from Encounter e where e.person.id=?1")
	public List<Encounter> getAllEncountersByPersonId(int id);
	
	@Query("select e from Encounter e where e.branchs.id=?1")
	public List<Encounter> getAllEncountersByBranchId(int id);
	
}
