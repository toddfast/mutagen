package com.toddfast.mutagen.simple.test.mutations.java;

import com.toddfast.mutagen.Mutation;
import com.toddfast.mutagen.State;
import com.toddfast.mutagen.basic.SimpleState;

/**
 *
 * @author Todd Fast
 */
public class MutationA implements Mutation<String> {

	public MutationA() {
		super();
	}


	@Override
	public State<String> getResultingState() {
		return state;
	}


	@Override
	public void mutate(Context context) {
		context.info("Mutating to \""+getResultingState()+"\"");

		Buffer buffer=(Buffer)context.getSubject();
		buffer.append(state.getID());
	}

	private State<String> state=new SimpleState<String>("a");
}
