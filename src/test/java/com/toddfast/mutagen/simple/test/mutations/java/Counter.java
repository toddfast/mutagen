package com.toddfast.mutagen.simple.test.mutations.java;

import com.toddfast.mutagen.State;
import com.toddfast.mutagen.Subject;
import com.toddfast.mutagen.basic.SimpleState;

/**
 *
 * @author Todd Fast
 */
public class Counter implements Subject<Integer> {

	public Counter(int state) {
		super();
		this.state=new SimpleState<Integer>(state);
	}

	@Override
	public State<Integer> getCurrentState() {
		return state;
	}

	public void increment() {
		state=new SimpleState<Integer>(state.getID()+1);
	}

	private State<Integer> state;
}
