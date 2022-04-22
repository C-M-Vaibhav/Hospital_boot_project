package com.ty.hospital.hospitalappboot.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.User;


public interface UserRepositary extends JpaRepository<User,Integer> {

}
