package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.dto.Medorder;
import com.ty.hospital.hospitalappboot.repositary.MedorderRepositary;
@Repository
public class MedorderDao {
	
	@Autowired
	MedorderRepositary repositary;
	
	@Autowired
	EncounterDao dao;
	
	public Medorder saveMedOrder(int e_id,Medorder medorder) {
		Encounter encounter = dao.getEncounterById(e_id);
		List<Item> items = medorder.getItems();
		for(Item item : items) {
			item.setMedOrder(medorder);
		}
		if(encounter!=null) {
			medorder.setEncounters(encounter);
			return repositary.save(medorder);
		}
		return null;
	}
	
	public Medorder getMedOrderById(int id) {
		Optional<Medorder> optional = repositary.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	public boolean deleteMedorderById(int id) {
		Medorder medorder = getMedOrderById(id);
		if(medorder !=null) {
			repositary.delete(medorder);
			return true;
		}
		return false;
	}
	
	public Medorder updateMedorder(int id,Medorder medorder) {
		Medorder m = getMedOrderById(id);
		if(m!=null) {
			return repositary.save(m);
		}
		return null;
	}
	
	public List<Medorder> allMedordersByEncounterId(int id){
		return repositary.getMedordersByEncounterId(id);
	}

}
