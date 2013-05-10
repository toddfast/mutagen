package com.toddfast.mutagen.basic;

import com.toddfast.mutagen.Coordinator;
import com.toddfast.mutagen.State;
import com.toddfast.mutagen.Subject;

/**
 * A trivial implementation of {@link Coordinator} that accepts all states
 * whose integer version number is greater than the subject's current version.
 * Note, this class makes no checks for gaps in version numbers, negative
 * version numbers, or any other potential anomalies.
 * 
 * @author Todd Fast
 */
public class MonotonicVersionCoordinator implements Coordinator<Integer> {

	/**
	 *
	 *
	 */
	public MonotonicVersionCoordinator() {
		super();
	}


	/**
	 *
	 *
	 */
	@Override
	public boolean accept(Subject<Integer> subject, State<Integer> targetState){
		return targetState.getID() > subject.getCurrentState().getID();
	}




	////////////////////////////////////////////////////////////////////////////
	// Fields
	////////////////////////////////////////////////////////////////////////////

	private Subject<Integer> subject;
}
