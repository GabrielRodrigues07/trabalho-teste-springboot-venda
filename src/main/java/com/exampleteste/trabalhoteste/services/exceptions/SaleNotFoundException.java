package com.exampleteste.trabalhoteste.services.exceptions;

public class SaleNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public SaleNotFoundException(Object id) {
		super("Venda não encontrada. id " + id);
	}
}
