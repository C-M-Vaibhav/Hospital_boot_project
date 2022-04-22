package com.ty.hospital.hospitalappboot.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hospital.hospitalappboot.dto.Medorder;

public interface MedorderRepositary extends JpaRepository<Medorder, Integer> {

	@Query("select m from Medorder m where m.encounter_id.id=?1")
	public List<Medorder> getMedordersByEncounterId(int id);
}
