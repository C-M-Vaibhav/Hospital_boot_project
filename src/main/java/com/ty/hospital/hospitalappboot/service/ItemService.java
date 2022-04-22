package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.Exception.NoFoundByIdException;
import com.ty.hospital.hospitalappboot.dao.ItemDao;
import com.ty.hospital.hospitalappboot.dto.Item;

@Service
public class ItemService {

	@Autowired
	ItemDao dao;

	public Item saveItem(int m_id, Item item) {
		return dao.saveItem(m_id, item);
	}

	public Item getItemById(int id) {
		Item item = dao.getItemById(id);
		if(item==null) {
			throw new NoFoundByIdException();
		}else {
			return item;
		}
	}

	public Item updateItemById(int id, Item item) {
		Item i = dao.updateItemByid(id, item);
		if(i==null) {
			throw new NoFoundByIdException();
		}else {
			return i;
		}
	}

	public boolean deleteItemById(int id) {
		return dao.deleteItemById(id);
	}
	
	public List<Item> ItemsByMedorderId(int m_id){
		return dao.getAllItemsInMedorder(m_id);
	}

}
