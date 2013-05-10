package com.toddfast.mutagen.simple;

import com.toddfast.mutagen.Mutation;
import com.toddfast.mutagen.Subject;

/**
 *
 * @author Todd Fast
 */
public class SimpleContext implements Mutation.Context {

	/**
	 *
	 *
	 */
	public SimpleContext(Subject subject) {
		super();
		this.subject=subject;
	}

	public Subject getSubject() {
		return subject;
	}


	public void info(String message,Object... parameters) {
		System.out.println(String.format(message,parameters));
	}


	public void debug(String message,Object... parameters) {
		System.out.println(String.format(message,parameters));
	}


	public void error(String message,Object... parameters) {
		System.err.println(String.format(message,parameters));
	}

	private Subject subject;
}
