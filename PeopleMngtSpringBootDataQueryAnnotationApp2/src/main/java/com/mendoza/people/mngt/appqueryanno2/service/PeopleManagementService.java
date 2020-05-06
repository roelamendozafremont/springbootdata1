package com.mendoza.people.mngt.appqueryanno2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendoza.people.mngt.appqueryanno2.dao.PeopleManagementDAO;
import com.mendoza.people.mngt.appqueryanno2.entity.Person;

@Service
public class PeopleManagementService {
	
	
	@Autowired
	private PeopleManagementDAO peopledao;
	
	
	public List<Person> getPersonsLikeFathersName(String fathersname) {
		// TODO Auto-generated method stub
		return peopledao.findLikefathersname(fathersname);
	}	
	
	public List<Person> getPersonsLikeFathersAndMothersName(String fathersname, String mothersname) {
		// TODO Auto-generated method stub
		return peopledao.findLikefathersAndmothersname(fathersname, mothersname);
	}		
	
	public List<Person> getPersonsByFathersName(String fathersname) {
		// TODO Auto-generated method stub
		return peopledao.findByfathersname(fathersname);
	}	
	
	public List<Person> getPersonsByFathersAndMothersName(String fathersname, String mothersname) {
		// TODO Auto-generated method stub
		return peopledao.findByfathersAndmothersname(fathersname, mothersname);
	}	
	
	
	public List<Person> getPersonsLikeFirstName2(String lastname) {
		// TODO Auto-generated method stub
		return peopledao.findLikefirstname2(lastname);
	}	
	
	public List<Person> getPersonsLikeFirstAndLastName2(String firstname,String lastname) {
		// TODO Auto-generated method stub
		return peopledao.findLikefirstAndlastname2(firstname, lastname);
	}		
		
	
	public List<Person> getPersonsLikeFirstName(String lastname) {
		// TODO Auto-generated method stub
		return peopledao.findLikefirstname(lastname);
	}	
	
	public List<Person> getPersonsLikeFirstAndLastName(String firstname,String lastname) {
		// TODO Auto-generated method stub
		return peopledao.findLikefirstAndlastname(firstname, lastname);
	}		
	
	public List<Person> getPersonsLikeLastName(String lastname) {
		// TODO Auto-generated method stub
		return peopledao.findLikelastname(lastname);
	}		

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
