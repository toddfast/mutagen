package com.toddfast.mutagen.simple;

import com.toddfast.mutagen.Coordinator;
import com.toddfast.mutagen.State;
import com.toddfast.mutagen.Subject;

/**
 *
 *
 * @author Todd Fast
 */
public class DumbStringCoordinator implements Coordinator<String> {

	/**
	 *
	 *
	 */
	public DumbStringCoordinator() {
		super();
	}


	/**
	 *
	 *
	 */
	@Override
	public boolean accept(Subject<String> subject, State<String> state) {

		boolean result=state.compareTo(subject.getCurrentState()) > 0;

		if (result) {
			System.out.println("Accepting state "+state);
		}
		else {
			System.out.println("Rejecting state "+state);
		}

		return result;
	}
}
