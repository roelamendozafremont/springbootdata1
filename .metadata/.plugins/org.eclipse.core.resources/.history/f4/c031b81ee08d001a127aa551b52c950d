package com.mendoza.people.mngt.appqueryanno.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mendoza.people.mngt.appqueryanno.entity.Person;

public interface PeopleManagementDAO extends CrudRepository<Person, String> {
		
	@Query(value="SELECT p from Person p WHERE p.fathersname = ?1") 
	List<Person> findByfathersname(String fathersname);	
	
	@Query(value="SELECT p from Person p WHERE p.fathersname = ?1 AND p.mothersname = ?2")
	List<Person> findByfathersAndmothersname(String fathersname, String mothersname);	
	
	List<Person> findBylastname(String lastname);
	
	List<Person> findByFirstnameAndLastname(String firstname, String lastname);
	
	List<Person> findLikefirstname(String lastname);
	
	List<Person> findLikelastname(String lastname);
	
	List<Person> findLikefirstname2(String lastname);
	
	List<Person> findLikefirstAndlastname(String firstname, String lastname);	
	
	List<Person> findLikefirstAndlastname2(String firstname, String lastname);	
	
}
