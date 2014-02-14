package com.toddfast.mutagen;

import com.toddfast.mutagen.Mutation.Context;

/**
 * Produces plans that can be executed to mutate the target subject to a given
 * state, using the coordinator to accept or reject mutations.
 *
 * @author Todd Fast
 */
public interface Planner<I extends Comparable<I>> {

	/**
	 *
	 *
	 */
	public Plan<I> getPlan(Context<I> context);
}
