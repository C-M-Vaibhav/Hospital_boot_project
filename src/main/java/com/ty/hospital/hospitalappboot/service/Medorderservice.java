package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.Exception.NoFoundByIdException;
import com.ty.hospital.hospitalappboot.dao.MedorderDao;
import com.ty.hospital.hospitalappboot.dto.Medorder;

@Service
public class Medorderservice {
	
	@Autowired
	MedorderDao dao;
	
	public Medorder saveMedorder(int e_id,Medorder medorder) {
		return dao.saveMedOrder(e_id, medorder);
	}
	public Medorder updateMedorder(int id,Medorder medorder) {
		Medorder m = dao.updateMedorder(id, medorder);
		if(m==null) {
			throw new NoFoundByIdException();
		}else {
			return m;
		}
	}
	public Medorder getMedorderByid(int id) {
		Medorder medorder = dao.getMedOrderById(id);
		if(medorder==null) {
			throw new NoFoundByIdException();
		}else {
			return medorder;
		}
	}
	public boolean deleteMedorderById(int id) {
		return dao.deleteMedorderById(id);
	}
	public List<Medorder> getMedordersByEncounterId(int e_id){
		List<Medorder> list = dao.allMedordersByEncounterId(e_id);
		if(list==null) {
			throw new NoFoundByIdException();
		}else {
			return list;
		}
	}

}
