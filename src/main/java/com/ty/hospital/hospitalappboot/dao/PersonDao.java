package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.repositary.PersonReapositary;



@Repository
public class PersonDao {
	
	@Autowired
	private PersonReapositary reapositary;
	
	public Person savePerson(Person person) {
		return reapositary.save(person);
	}
	
	public Person getPersonById(int id) {
		Optional<Person> opt = reapositary.findById(id);
		if(opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}
	
//	public Person getPersonbyId(int id) {
//		return reapositary.getById(id);
//	}
	
	public List<Person> getAllPersons(){
		return reapositary.findAll();
	}
	
	public boolean deletePersonById(@RequestParam int id) {
		Person person = getPersonById(id);
		if(person!=null) {
			reapositary.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Person updatePerson(int id,Person person) {
		Person p = getPersonById(id);
		if(p!= null) {
			reapositary.save(person);
			return person;
		}
		return null;
	}
	

}
