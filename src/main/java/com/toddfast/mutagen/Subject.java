package com.toddfast.mutagen;

/**
 * A resource to be modified by applying a series of mutations
 * 
 * @author Todd Fast
 */
public interface Subject<I extends Comparable<I>> {

	/**
	 * The current state of the underlying resource
	 *
	 */
	public State<I> getCurrentState();
}
