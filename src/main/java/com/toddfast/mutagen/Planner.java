package com.toddfast.mutagen;

/**
 *
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
