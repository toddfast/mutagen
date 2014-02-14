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
public class BasicContext<I extends Comparable<I>> implements Mutation.Context<I> {

	/**
	 *
	 *
	 */
	public BasicContext(Subject<I> subject, Coordinator<I> coordinator) {
		super();
		this.subject=subject;
		this.coordinator=coordinator;
	}


	/**
	 *
	 *
	 */
	@Override
	public Subject<I> getSubject() {
		return subject;
	}


	/**
	 *
	 *
	 */
	@Override
	public Coordinator<I> getCoordinator() {
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

	private Subject<I> subject;
	private Coordinator<I> coordinator;
}
