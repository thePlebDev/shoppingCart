package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.PersonNotFoundException;
import com.example.demo.models.Cart;
import com.example.demo.models.Person;
import com.example.demo.repositories.CartRepository;
import com.example.demo.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	private final CartService cartService;
	
	@Autowired
	public PersonService(PersonRepository personRepository,CartService cartService) {
		this.cartService = cartService;
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
		// find the cart, find the person.
		 Cart cart = cartService.findCart(cartId);
		 Person person = findPerson(personId);
		 
		 //set cart and set person
		 cart.setPerson(person);
		 person.setCart(cart);
		 
		 // save person and save will cascade down to cart
		 personRepository.save(person);
		 return person;
		 
	}

}
