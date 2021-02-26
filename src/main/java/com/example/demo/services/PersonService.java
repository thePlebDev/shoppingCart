package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.PersonNotFoundException;
import com.example.demo.models.Person;
import com.example.demo.repositories.CartRepository;
import com.example.demo.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	private final CartRepository cartRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository,CartRepository cartRepository) {
		this.cartRepository = cartRepository;
		this.personRepository = personRepository;
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	public Person findPerson(Long id) {
		return personRepository.findById(id)
				.orElseThrow(()-> new PersonNotFoundException(id));
	}
	public Person addCart(Long personId, Long cartId) {
		//CREATE THE CART SERVICE FIRST
	}

}
