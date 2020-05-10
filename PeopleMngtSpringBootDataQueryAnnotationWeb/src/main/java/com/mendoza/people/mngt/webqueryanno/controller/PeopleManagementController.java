package com.mendoza.people.mngt.webqueryanno.controller;



import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mendoza.people.mngt.webqueryanno.entity.Person;
import com.mendoza.people.mngt.webqueryanno.service.PeopleManagementService;


@RestController
@RequestMapping("/people-mngt-jpa")
public class PeopleManagementController {
	
	

	@Autowired
	private PeopleManagementService service;

	
	@GetMapping("/findAllPersons")
	public Iterable<Person> findAllPersons() {
		// TODO Auto-generated method stub
		Iterable<Person> ipersons = service.findAllPersons();
		ipersons.forEach((p) -> System.out.println(p.returnPrintString()));
		return ipersons;
	}
	
	@GetMapping("/findPersonsByName/{name}")
	public Iterable<Person> findPersonsByName(@PathVariable("name") String name) {
		// TODO Auto-generated method stub
		Iterable<Person> ipersons = service.findPersonsByName(name);
		ipersons.forEach((p) -> System.out.println(p.returnPrintString()));
		return ipersons;
	}
	
	@PostMapping("/addPerson")
	public void addPerson(@NonNull @Valid @RequestBody Person person) {
		person.setCreationdate(new Date());
		service.addPerson(person);
		System.out.println("added to repo ==> " + person.returnPrintString());
	}
	
	@DeleteMapping("/deletePerson")
	public void deletePerson(@NonNull @Valid @RequestBody Person person) {
		service.deletePerson(person);
		System.out.println("deleted from repo ==> " + person.returnPrintString());
	}

	@PutMapping("/updatePerson")
	public void updatePerson(@NonNull @Valid @RequestBody Person person) {
		person.setCreationdate(new Date());
		service.updatePerson(person);
		System.out.println("updated to repo ==> " + person.returnPrintString());
	}
	
	
	
	
}
