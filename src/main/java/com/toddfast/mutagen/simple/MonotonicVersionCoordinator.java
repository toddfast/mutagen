package com.toddfast.mutagen.simple;

import com.toddfast.mutagen.Coordinator;
import com.toddfast.mutagen.State;
import com.toddfast.mutagen.Subject;

/**
 *
 * 
 * @author Todd Fast
 */
public class MonotonicVersionCoordinator implements Coordinator<Integer> {

	/**
	 *
	 *
	 */
	public MonotonicVersionCoordinator(Subject<Integer> subject) {
		super();
		this.subject=subject;
	}


	/**
	 *
	 *
	 */
	public Subject<Integer> getSubject() {
		return subject;
	}


	/**
	 *
	 *
	 */
	@Override
	public boolean accept(State<Integer> state) {
		return state.getID() > getSubject().getCurrentState().getID();
	}




	////////////////////////////////////////////////////////////////////////////
	// Fields
	////////////////////////////////////////////////////////////////////////////

	private Subject<Integer> subject;
}
