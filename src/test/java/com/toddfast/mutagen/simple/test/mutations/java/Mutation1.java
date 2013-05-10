package com.toddfast.mutagen.simple.test.mutations.java;

import com.toddfast.mutagen.Mutation;
import com.toddfast.mutagen.State;
import com.toddfast.mutagen.basic.SimpleState;

/**
 *
 * @author Todd Fast
 */
public class Mutation1 implements Mutation<Integer> {

	public Mutation1() {
		super();
	}


	@Override
	public State<Integer> getResultingState() {
		return state;
	}


	@Override
	public void mutate(Context context) {
		context.info("Mutating to \""+getResultingState()+"\"");

		Counter counter=(Counter)context.getSubject();
		counter.increment();
	}

	private State<Integer> state=new SimpleState<Integer>(1);
}
