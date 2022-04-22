package com.ty.hospital.hospitalappboot.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.Person;

public interface PersonReapositary extends JpaRepository<Person,Integer> {
}
