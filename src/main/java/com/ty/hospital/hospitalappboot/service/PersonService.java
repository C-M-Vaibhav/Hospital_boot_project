package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.Exception.NoFoundByIdException;
import com.ty.hospital.hospitalappboot.dao.PersonDao;
import com.ty.hospital.hospitalappboot.dto.Person;

@Service
public class PersonService {
	
	@Autowired
	PersonDao dao;
	
	public Person savePerson(Person person) {
		return dao.savePerson(person);
	}
	
	public Person getByPersonId(int id) {
		Person person = dao.getPersonById(id);
		if(person==null) {
			throw new NoFoundByIdException();
		}else {
			return person;
		}
	}
	
	public boolean deletePersonById(int id) {
		boolean b = dao.deletePersonById(id);
		if(b==false) {
			throw new NoFoundByIdException();
		}
		return true;
	}

	public Person updatePersonById(int id,Person person) {
		Person p = dao.updatePerson(id, person);
		if(p==null) {
			throw new NoFoundByIdException();
		}else {
			return p;
		}
	}
	
	public List<Person> getAllPersons() {
		List<Person> list = dao.getAllPersons();
		if(list==null) {
			throw new NoFoundByIdException();
		}else {
			return list;
		}
	}
}
