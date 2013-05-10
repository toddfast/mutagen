package com.toddfast.mutagen;

/**
 *
 * 
 * @author Todd Fast
 */
public class MutagenException extends RuntimeException {

	/**
	 *
	 *
	 */
	public MutagenException() {
		super();
	}


	/**
	 *
	 *
	 */
	public MutagenException(String message) {
		super(message);
	}


	/**
	 *
	 *
	 */
	public MutagenException(Throwable rootCause) {
		super(rootCause);
	}


	/**
	 *
	 *
	 */
	public MutagenException(String message, Throwable rootCause) {
		super(message,rootCause);
	}

}
