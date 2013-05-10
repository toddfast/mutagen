package com.toddfast.mutagen.basic;

import com.toddfast.mutagen.Coordinator;
import com.toddfast.mutagen.Mutation;
import com.toddfast.mutagen.Subject;

/**
 * Implements the basic contract of {@link Mutation.Context}. Logs to
 * {@link System.out} and {@link System.err}.
 * 
 * @author Todd Fast
 */
public class BasicContext implements Mutation.Context {

	/**
	 *
	 *
	 */
	public BasicContext(Subject<?> subject, Coordinator<?> coordinator) {
		super();
		this.subject=subject;
		this.coordinator=coordinator;
	}


	/**
	 *
	 *
	 */
	@Override
	public Subject<?> getSubject() {
		return subject;
	}


	/**
	 *
	 *
	 */
	@Override
	public Coordinator<?> getCoordinator() {
		return coordinator;
	}


	/**
	 *
	 *
	 */
	@Override
	public void info(String message, Object... parameters) {
		System.out.println(String.format(message,parameters));
	}


	/**
	 *
	 *
	 */
	@Override
	public void debug(String message, Object... parameters) {
		System.err.println(String.format(message,parameters));
	}


	/**
	 *
	 *
	 */
	@Override
	public void error(String message, Object... parameters) {
		System.err.println(String.format(message,parameters));
	}




	////////////////////////////////////////////////////////////////////////////
	// Fields
	////////////////////////////////////////////////////////////////////////////

	private Subject<?> subject;
	private Coordinator<?> coordinator;
}
