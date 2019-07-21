package com.sales.exceptions;

public class BookCustNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -192629000403106449L;

	public BookCustNotFoundException(String message){
		super(message);
	}
}
