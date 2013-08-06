package com.codenvy.testtask.qname;

/**
 * The IllegalNameException class 
 * extends the {@link java.lang.Exception}. 
 * Thrown to indicate that argument name is illegal
 * 
 * @author Vladimir Bezpalchuk
 * 
 * @version 1.0 03 Aug 2013.
 */
public class IllegalNameException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an IllegalNameException with no detail message.
	 */
	public IllegalNameException() {

	}

	/**
	 * Constructs an IllegalNameException with the specified detail message.
	 */
	public IllegalNameException(String arg0) {
		super(arg0);
	}

}
