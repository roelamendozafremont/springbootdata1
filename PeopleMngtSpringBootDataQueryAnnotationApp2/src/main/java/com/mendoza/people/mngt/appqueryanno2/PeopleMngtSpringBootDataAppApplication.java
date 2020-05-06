package com.mendoza.people.mngt.appqueryanno2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mendoza.people.mngt.appqueryanno2.entity.Person;
import com.mendoza.people.mngt.appqueryanno2.service.PeopleManagementService;

@SpringBootApplication
public class PeopleMngtSpringBootDataAppApplication implements CommandLineRunner {

	@Autowired
	private PeopleManagementService service;
	
	public static void main(String[] args) {
		SpringApplication.run(PeopleMngtSpringBootDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=============================================");		
		System.out.println("Deleting Person table...");
		deleteByEmailId("kletroel@gmail.com");
		deleteAllPersons();

		System.out.println("=============================================");
		System.out.println("Creating Person table...");		
		createPerson();
		createPersons();

		System.out.println("=============================================");
		System.out.println("Finding person by JPA entity...");
		findAllPersons();
		findbyEmailId("roelklet@gmail.com");				
		
		System.out.println("=============================================");
		System.out.println("Finding person by JPA custom method...");
		getPersonByLastName("mendoza");
		getPersonByFirstAndLastName("roel","mendoza");
		
		System.out.println("=============================================");
		System.out.println("Finding person by JPA named query...");		
		getPersonLikeFirstName("%ro%");
		getPersonLikeFirstAndLastName("%t%","%ca%");		
		
		System.out.println("=============================================");
		System.out.println("Finding person by JPA named native query...");		
		getPersonLikeFirstName2("%ro%");
		getPersonLikeFirstAndLastName2("%t%","%ca%");
		
		System.out.println("=============================================");
		System.out.println("Finding person by JPA @query annotation...");		
		getPersonByFathersName("renato");
		getPersonByFathersAndMothersName("roel","christina");
		
		System.out.println("=============================================");
		System.out.println("Finding person by JPA @query native annotation...");		
		getPersonLikeFathersName("%cas%");
		getPersonLikeFathersAndMothersName("%cas%","%ana%");		
				
	}
	
	public void getPersonLikeFathersName(String fathersname) {
		List<Person> lpersons = service.getPersonsLikeFathersName(fathersname);
		lpersons.forEach(p -> System.out.println(p.returnPrintString()));
	}
	
	public void getPersonLikeFathersAndMothersName(String fathersname, String mothersname) {
		List<Person> lpersons = service.getPersonsLikeFathersAndMothersName(fathersname, mothersname);
		lpersons.forEach(p -> System.out.println(p.returnPrintString()));
	}		
	
	public void getPersonByFathersName(String fathersname) {
		List<Person> lpersons = service.getPersonsByFathersName(fathersname);
		lpersons.forEach(p -> System.out.println(p.returnPrintString()));
	}
	
	public void getPersonByFathersAndMothersName(String fathersname, String mothersname) {
		List<Person> lpersons = service.getPersonsByFathersAndMothersName(fathersname, mothersname);
		lpersons.forEach(p -> System.out.println(p.returnPrintString()));
	}	

	public void getPersonLikeFirstAndLastName(String firstname, String lastname) {
		List<Person> lpersons = service.getPersonsLikeFirstAndLastName(firstname, lastname);
		lpersons.forEach(p -> System.out.println(p.returnPrintString()));
	}

	public void getPersonLikeFirstName(String lastname) {
		List<Person> lpersons = service.getPersonsLikeFirstName(lastname);
		lpersons.forEach(p -> System.out.println(p.returnPrintString()));
	}
	
	public void getPersonLikeFirstAndLastName2(String firstname, String lastname) {
		List<Person> lpersons = service.getPersonsLikeFirstAndLastName2(firstname, lastname);
		lpersons.forEach(p -> System.out.println(p.returnPrintString()));
	}

	public void getPersonLikeFirstName2(String lastname) {
		List<Person> lpersons = service.getPersonsLikeFirstName2(lastname);
		lpersons.forEach(p -> System.out.println(p.returnPrintString()));
	}	
	
	public void getPersonByLastName(String lastname) {
		List<Person> lpersons = service.getPersonsByLastName(lastname);
		lpersons.forEach(p -> System.out.println(p.returnPrintString()));
	}
	
	public void getPersonByFirstAndLastName(String firstname, String lastname) {
		List<Person> lpersons = service.getPersonsByFirstAndLastName(firstname, lastname);
		lpersons.forEach(p -> System.out.println(p.returnPrintString()));
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
		ipersons.forEach((p) -> System.out.println(p.returnPrintString()));
	}
	
	private void findbyEmailId(String emailid) {
		// TODO Auto-generated method stub
		System.out.println(service.findbyEmailId(emailid).toString());
	}
	
	private void createPerson() {
		// TODO Auto-generated method stub
		Person p1 = new Person("roel","mendoza","m","1973","renato","julie","roel.mendoza@gmail.com");
		Person p1db = service.createPerson(p1);
		System.out.println(p1db.returnPrintString());
	}
	
	
	private void createPersons() {
		// TODO Auto-generated method stub
		List<Person> persons = new ArrayList<Person>()  ;
		persons.add(new Person("roen","mendoza","m","2009","roel","christina","roenklet@gmail.com"));
		persons.add(new Person("rae","mendoza","f","2007","roel","christina","raeklet@gmail.com"));
		persons.add(new Person("klet","mendoza","f","1977","castor","anastacia","kletroel@gmail.com"));
		persons.add(new Person("topel","cayaba","m","1975","castor","anastacia","topel.cayaba@gmail.com"));	
		persons.add(new Person("ian","cayaba","m","1979","castor","anastacia","ian.cayaba@gmail.com"));		
		persons.add(new Person("ton","cayaba","m","1981","castor","anastacia","ton.cayaba@gmail.com"));		
		persons.add(new Person("fred","cayaba","m","1983","castor","anastacia","fred.cayaba@gmail.com"));		
		persons.add(new Person("mac","cayaba","m","1985","castor","anastacia","mac.cayaba@gmail.com"));				
		Iterable<Person> ipersons = service.createPersons(persons);
		System.out.println(ipersons);
	}

}
