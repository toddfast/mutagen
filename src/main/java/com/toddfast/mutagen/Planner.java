package com.toddfast.mutagen;

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
	public Plan<I> getPlan(Subject<I> subject, Coordinator<I> coordinator);
}
