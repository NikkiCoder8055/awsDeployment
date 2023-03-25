package com.person.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.Model.Person;
import com.person.Repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personrepo;

	//create Person
	@Override
	public Person createPerson(Person person) {
		return personrepo.save(person);
	}
    //View person
	@Override
	public List<Person> getAllPerson() {
		return personrepo.findAll();
	}
    //ViewById
	@Override
	public Person findByID(int id) {
		Optional<Person> findById = this.personrepo.findById(id);
		return findById.get();
	}
    //DeletePerson
	@Override
	public void deleteByID(int id) {
		this.personrepo.deleteById(id);
	}
	
}
