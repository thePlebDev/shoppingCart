package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="person_generator")
	@SequenceGenerator(name="person_generator", allocationSize= 1)
	private long id;
	private String name;
	//NEED THE ONE TO ONE RELATION
	@OneToOne( fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy="person",
			orphanRemoval = true
			)
	private Cart cart;
	
	public Person(String name) {
		this.name = name;
	}
	public Person(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
