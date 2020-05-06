package com.mendoza.people.mngt.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendoza.people.mngt.app.dao.PeopleManagementDAO;
import com.mendoza.people.mngt.app.entity.Person;

@Service
public class PeopleManagementService {
	
	
	@Autowired
	private PeopleManagementDAO peopledao;
	
	public Person createPerson(Person p) {
		return peopledao.save(p);
	}
	
	public Iterable<Person> createPersons(List<Person> persons) {
		return peopledao.saveAll(persons);
	}

	public Iterable<Person> findAllPersons() {
		return peopledao.findAll();
	}

	public Optional<Person> findbyEmailId(String emailid) {
		return peopledao.findById(emailid);
	}	
	
	public void deleteAllPersons() {
		 peopledao.deleteAll();;
	}

	public void deletebyEmailId(String emailid) {
		peopledao.deleteById(emailid);
	}	
	
}
