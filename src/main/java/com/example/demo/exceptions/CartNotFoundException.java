package com.example.demo.exceptions;

import java.text.MessageFormat;

public class CartNotFoundException extends RuntimeException{
		
	public CartNotFoundException(long id) {
		super(MessageFormat.format("Cart with id {0} not found", id));
	}
}
