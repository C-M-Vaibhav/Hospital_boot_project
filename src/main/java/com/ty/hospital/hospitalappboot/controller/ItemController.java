package com.ty.hospital.hospitalappboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.dao.ItemDao;
import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	ItemService service;
	
	@PostMapping("/Medorder/{m_id}/Item")
	public Item saveItem(@PathVariable(value="m_id") int m_id,@RequestBody Item item) {
		return service.saveItem(m_id, item);
	}
	
	@GetMapping("/item")
	public Item getItemById(@RequestParam int id) {
		return service.getItemById(id);
	}
	
	@PostMapping("/getItem")
	public Item getItem() {
		return new Item();
	}
	
	@DeleteMapping("/item")
	public void delete(@RequestParam int id) {
		service.deleteItemById(id);
	}
	
	@PutMapping("/item")
	public Item updateItem(@RequestParam int id,@RequestBody Item item) {
		return service.updateItemById(id, item);
	}
	
	@GetMapping("/items")
	public List<Item> itemsByMeorderId(@RequestParam int m_id){
		return service.ItemsByMedorderId(m_id);
	}

}
