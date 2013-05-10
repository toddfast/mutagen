package com.toddfast.mutagen;

/**
 * Coordinates acceptance of state mutations to a subject. Mutation acceptance
 * may be based on simple state comparisons, or potentially based on more
 * complex rules, coordination of mutations in a resource cluster, or any other
 * means.
 * <p/>
 * When a state is accepted, it is presumably safe to be applied to a target
 * subject.
 * 
 * @author Todd Fast
 */
public interface Coordinator<I extends Comparable<I>> {

	/**
	 *
	 *
	 */
	public boolean accept(Subject<I> subject, State<I> targetState);
}
