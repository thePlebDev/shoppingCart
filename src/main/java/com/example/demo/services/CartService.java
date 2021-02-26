package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.CartNotFoundException;
import com.example.demo.models.Cart;
import com.example.demo.repositories.CartRepository;

@Service
public class CartService {
	private final CartRepository cartRepository;
	
	@Autowired
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	// I need to create a findCart and createCart
	
	public Cart createCart(Cart cart ) {
		return cartRepository.save(cart);
	}
	
	public Cart findCart(Long id) {
		return cartRepository.findById(id)
				.orElseThrow(()-> new CartNotFoundException(id));
	}

}
