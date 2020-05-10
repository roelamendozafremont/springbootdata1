package com.mendoza.people.mngt.webqueryanno.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendoza.people.mngt.webqueryanno.dao.PeopleManagementDAO;
import com.mendoza.people.mngt.webqueryanno.entity.Person;

@Service
public class PeopleManagementService {
	
	
	@Autowired
	private PeopleManagementDAO peopledao;

	public Iterable<Person> findAllPersons() {
		return peopledao.findAll();
	}

	public void addPerson(Person person) {
		peopledao.save(person);
	}
	
	public void deletePerson(Person person) {
		peopledao.delete(person);
	}
	
	public void updatePerson(Person person) {
		peopledao.deleteById(person.getEmailid());
		peopledao.save(person);
	}
	
	public Iterable<Person> findPersonsByName(String lastname) {
		return peopledao.findBylastname(lastname);
	}
}
