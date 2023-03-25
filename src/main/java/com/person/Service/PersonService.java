package com.person.Service;

import java.util.List;

import com.person.Model.Person;

public interface PersonService {
	
	//create Person
	Person createPerson(Person person);
	
	//getAllPersonList.
	List<Person> getAllPerson();
	
	//deletePerson
	 void deleteByID(int id);
	 
	//UpdatePerson
	 Person findByID(int id);


}
