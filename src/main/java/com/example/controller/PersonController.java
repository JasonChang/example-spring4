package com.example.controller;
import java.util.List;

import com.example.entity.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/person",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class PersonController {
	@Autowired
	private PersonService personService;

	@RequestMapping(value="/{id}", method = RequestMethod.GET )
	public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
		Person person = personService.getPersonById(id);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	@RequestMapping(value= "", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> list = personService.getAllPersons();
		return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	}
	@RequestMapping(value= "", method = RequestMethod.POST)
	public ResponseEntity<Long> addPerson(@RequestBody Person person) {
		personService.saveAndUpdatePerson(person);
        return new ResponseEntity<Long>(person.getPid(), HttpStatus.CREATED);
	}
	@RequestMapping(value="/{id}", method = RequestMethod.PUT )
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
		Person old = personService.getPersonById(person.getPid());
		if(old != null){
			old.setName(person.getName());
			old.setLocation(person.getLocation());
			personService.saveAndUpdatePerson(person);
		}

		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id) {
		personService.deletePerson(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}	
} 