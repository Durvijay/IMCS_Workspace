package com.imcs.exception;

public class EmployeeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7969025719728519852L;

	public EmployeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmployeeException(Throwable cause) {
		super(cause);
	}

	public EmployeeException(String message) {
		super(message);
	}

	public EmployeeException() {
		super();
	}

	public EmployeeException(String message, Throwable arg1) {
		super(message, arg1);
	}
}