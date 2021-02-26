package com.example.demo.exceptions;

import java.text.MessageFormat;

public class PersonNotFoundException extends RuntimeException{
	
	public PersonNotFoundException(Long id) {
		super(MessageFormat.format("Person with id {0} not found", id));
	}

}
