package com.toddfast.mutagen.simple.test.mutations.java;

import com.toddfast.mutagen.Mutation;
import com.toddfast.mutagen.State;
import com.toddfast.mutagen.simple.SimpleState;

/**
 *
 * @author Todd Fast
 */
public class MutationB implements Mutation<String> {

	public MutationB() {
		super();
	}


	@Override
	public State<String> getResultingState() {
		return state;
	}


	@Override
	public State<String> mutate(Context context) {
		context.info("Mutating to \""+getResultingState()+"\"");

		Buffer buffer=(Buffer)context.getSubject();
		buffer.append(state.getID());

		return getResultingState();
	}

	private State<String> state=new SimpleState<String>("b");
}
