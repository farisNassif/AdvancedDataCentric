package com.sales.exceptions;

public class BookAlreadyOnLoanException extends RuntimeException {
	private static final long serialVersionUID = -7594691653077979153L;

	public BookAlreadyOnLoanException(String message) {
		super(message);
	}
}
