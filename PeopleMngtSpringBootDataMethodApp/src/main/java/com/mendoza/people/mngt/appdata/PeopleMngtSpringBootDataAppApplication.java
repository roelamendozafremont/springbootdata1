package com.mendoza.people.mngt.appdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mendoza.people.mngt.appdata.entity.Person;
import com.mendoza.people.mngt.appdata.service.PeopleManagementService;

@SpringBootApplication
public class PeopleMngtSpringBootDataAppApplication implements CommandLineRunner {

	@Autowired
	private PeopleManagementService service;
	
	public static void main(String[] args) {
		SpringApplication.run(PeopleMngtSpringBootDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		deleteByEmailId("roelklet@gmail.com");
		deleteAllPersons();
		
		//findbyEmailId("roelklet@gmail.com");
		
		createPerson();
		createPersons();
		
		findAllPersons();
		findbyEmailId("roelklet@gmail.com");
				
		
		getPersonByLastName("mendoza");
		getPersonByFirstAndLastName("roel","mendoza");
		
	}

	public void getPersonByLastName(String lastname) {
		List<Person> lpersons = service.getPersonsByLastName(lastname);
		lpersons.forEach(p -> System.out.println(p.getLastname()+", "+p.getFirstname()));
	}
	
	public void getPersonByFirstAndLastName(String firstname, String lastname) {
		List<Person> lpersons = service.getPersonsByFirstAndLastName(firstname, lastname);
		lpersons.forEach(p -> System.out.println(p.getLastname()+", "+p.getFirstname()));
	}
	
	private void deleteByEmailId(String emailid) {
		// TODO Auto-generated method stub
		service.deletebyEmailId(emailid);
	}	
	
	
	private void deleteAllPersons() {
		// TODO Auto-generated method stub
		service.deleteAllPersons();
	}	
	
	private void findAllPersons() {
		// TODO Auto-generated method stub
		Iterable<Person> ipersons = service.findAllPersons();
		ipersons.forEach((p) -> System.out.println(p.getEmailid()));
	}
	
	private void findbyEmailId(String emailid) {
		// TODO Auto-generated method stub
		System.out.println(service.findbyEmailId(emailid).toString());
	}
	
	private void createPerson() {
		// TODO Auto-generated method stub
		Person p1 = new Person("roel","mendoza","roelklet@gmail.com",new Date());
		Person p1db = service.createPerson(p1);
		System.out.println(p1db);
	}
	
	
	private void createPersons() {
		// TODO Auto-generated method stub
		List<Person> persons = new ArrayList<Person>()  ;
		persons.add(new Person("roen","mendoza","roenklet@gmail.com",new Date()));
		persons.add(new Person("rae","mendoza","raeklet@gmail.com",new Date()));
		persons.add(new Person("klet","mendoza","kletroel@gmail.com",new Date()));
		persons.add(new Person("topel","cayaba","topel.cayaba@gmail.com",new Date()));	
		persons.add(new Person("ian","cayaba","ian.cayaba@gmail.com",new Date()));		
		persons.add(new Person("ton","cayaba","ton.cayaba@gmail.com",new Date()));		
		persons.add(new Person("fred","cayaba","fred.cayaba@gmail.com",new Date()));		
		persons.add(new Person("mac","cayaba","mac.cayaba@gmail.com",new Date()));				
		Iterable<Person> ipersons = service.createPersons(persons);
		System.out.println(ipersons);
	}

}