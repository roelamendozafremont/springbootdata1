package com.mendoza.people.mngt.app.dao;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mendoza.people.mngt.app.entity.Person;

public interface PeopleManagementDAO extends CrudRepository<Person, String> {
	
	

}
