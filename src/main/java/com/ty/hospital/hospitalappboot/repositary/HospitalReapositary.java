package com.ty.hospital.hospitalappboot.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.Hospital;

public interface HospitalReapositary extends JpaRepository<Hospital, Integer> {
	

}
