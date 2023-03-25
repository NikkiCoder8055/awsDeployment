package com.person.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.Model.Person;
import com.person.Service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	private PersonService personservice;

	@PostMapping("/")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		Person createPerson = this.personservice.createPerson(person);
		return new ResponseEntity<>(createPerson, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<Person>> getAllPerson() {
		List<Person> allPerson = this.personservice.getAllPerson();
		return new ResponseEntity<>(allPerson, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByID(@PathVariable int id) {
		Person findByID = this.personservice.findByID(id);
		if (findByID == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		this.personservice.deleteByID(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> update(@PathVariable int id ,@RequestBody Person person){
		Person findByID = this.personservice.findByID(id);
		if(findByID==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		person.setId(id);
		personservice.createPerson(person);
		return new ResponseEntity<>(person,HttpStatus.OK);
	}

}
