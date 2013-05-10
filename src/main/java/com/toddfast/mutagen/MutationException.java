package com.toddfast.mutagen;

/**
 *
 * 
 * @author Todd Fast
 */
public class MutationException extends RuntimeException {

	/**
	 *
	 *
	 */
	public MutationException() {
		super();
	}


	/**
	 *
	 *
	 */
	public MutationException(String message) {
		super(message);
	}


	/**
	 *
	 *
	 */
	public MutationException(Throwable rootCause) {
		super(rootCause);
	}


	/**
	 *
	 *
	 */
	public MutationException(String message, Throwable rootCause) {
		super(message,rootCause);
	}

}
