package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.dto.Medorder;
import com.ty.hospital.hospitalappboot.repositary.ItemRepositary;

@Repository
public class ItemDao {
	
	@Autowired
	ItemRepositary repositary;
	
	@Autowired
	MedorderDao dao;
	
	public Item saveItem(int id,Item item) {
		Medorder medorder = dao.getMedOrderById(id);
		if(medorder!=null) {
			item.setMedOrder(medorder);
			return repositary.save(item);
		}
		return null;
	}
	
	public Item getItemById(int id) {
		Optional<Item> opt = repositary.findById(id);
		if(opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}
	
	public Item updateItemByid(int id,Item item) {
		Item item1 = getItemById(id);
		if(item1!=null) {
			return repositary.save(item);
		}
		return null;
	}
	
	public boolean deleteItemById(int id) {
		Item item = getItemById(id);
		if(item!=null) {
			repositary.delete(item);
			return true;
		}
		return false;
	}
	
	public List<Item> getAllItemsInMedorder(int m_id){
		return repositary.getItemsByMedorderId(m_id);
	}

}
