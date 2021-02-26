package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Cart;
import com.example.demo.services.CartService;

@ResponseBody
@RequestMapping("api/v1/cart")
public class CartController {
	private final CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping
	public Cart createCart(@RequestBody Cart cart) {
		return cartService.createCart(cart);
	}
	
	@GetMapping("{id}")
	public Cart findCart(@PathVariable Long id) {
		return cartService.findCart(id);
	}
	
	

}
