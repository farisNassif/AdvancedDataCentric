package com.sales.exceptions;

public class NoSuchLoanException extends RuntimeException{
	private static final long serialVersionUID = 5213076870663982412L;

	public NoSuchLoanException(String message){
		super(message);
	}
}
