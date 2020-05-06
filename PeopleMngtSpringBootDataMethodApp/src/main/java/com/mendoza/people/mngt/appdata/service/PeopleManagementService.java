package com.mendoza.people.mngt.appdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendoza.people.mngt.appdata.dao.PeopleManagementDAO;
import com.mendoza.people.mngt.appdata.entity.Person;

@Service
public class PeopleManagementService {
	
	
	@Autowired
	private PeopleManagementDAO peopledao;

	public List<Person> getPersonsByLastName(String lastname) {
		// TODO Auto-generated method stub
		return peopledao.findBylastname(lastname);
	}
	
	
	public List<Person> getPersonsByFirstAndLastName(String firstname, String lastname) {
		// TODO Auto-generated method stub
		return peopledao.findByFirstnameAndLastname(firstname, lastname);
	}
	
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
