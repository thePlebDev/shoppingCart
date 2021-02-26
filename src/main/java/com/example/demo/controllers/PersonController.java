package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Person;
import com.example.demo.services.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
	private final PersonService personService;
	
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
	
	@GetMapping("{id}")
	public Person findPerson(@PathVariable Long id) {
		return personService.findPerson(id);
	}
	
	@PutMapping("{personId}/{cartId}")
	public Person addCart(@PathVariable Long personId, @PathVariable Long cartId) {
			return personService.addCart(personId, cartId);
		}
}
