package com.mendoza.people.mngt.webqueryanno.dao;


import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mendoza.people.mngt.webqueryanno.entity.Person;

public interface PeopleManagementDAO extends CrudRepository<Person, String> {

	Iterable<Person> findBylastname(String lastname);
	
			
}
