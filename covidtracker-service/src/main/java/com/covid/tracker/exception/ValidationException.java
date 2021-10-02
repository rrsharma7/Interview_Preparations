package com.covid.tracker.exception;

public class ValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7832781591091126686L;

	public ValidationException(String errMsg) {
		super(errMsg);
	}

}
