package com.mendoza.people.mngt.appnativequery.dao;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mendoza.people.mngt.appnativequery.entity.Person;

public interface PeopleManagementDAO extends CrudRepository<Person, String> {
		
	
	List<Person> findBylastname(String lastname);
	
	List<Person> findByFirstnameAndLastname(String firstname, String lastname);
	
	List<Person> findLikefirstname(String lastname);
	
	List<Person> findLikelastname(String lastname);
	
	List<Person> findLikefirstname2(String lastname);
	
	List<Person> findLikefirstAndlastname(String firstname, String lastname);	
	
	List<Person> findLikefirstAndlastname2(String firstname, String lastname);	
	
}
