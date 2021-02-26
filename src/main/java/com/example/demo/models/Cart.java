package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cart {
	private String name;
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="cart_generator")
	@SequenceGenerator(name="cart_generator", allocationSize= 1)
	private Long id;
	
	@OneToOne
	@JoinTable(name="person_id")
	private Person person;
	
	public Cart(String name) {
		this.name = name;
	}
	public Cart() {}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Person getPerson() {
		return person;
	}

}
