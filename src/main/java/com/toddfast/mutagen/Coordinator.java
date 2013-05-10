package com.toddfast.mutagen;

/**
 *
 * 
 * @author Todd Fast
 */
public interface Coordinator<I extends Comparable<I>> {

	/**
	 *
	 *
	 */
	public boolean accept(State<I> state);
}
