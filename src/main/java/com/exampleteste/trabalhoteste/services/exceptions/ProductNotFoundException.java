package com.exampleteste.trabalhoteste.services.exceptions;

public class ProductNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(Object id) {
		super("Product not found. id " + id);
	}
}
