package com.ty.hospital.hospitalappboot.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hospital.hospitalappboot.dto.Item;

public interface ItemRepositary  extends JpaRepository<Item, Integer> {
	@Query("select i from Item i where i.medOrder.id=?1")
	public List<Item> getItemsByMedorderId(int id);

}
