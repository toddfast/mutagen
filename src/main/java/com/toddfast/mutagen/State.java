package com.toddfast.mutagen;

/**
 * Encapsulates the state of a resource as a comparable value
 * 
 * @author Todd Fast
 */
public interface State<I extends Comparable<I>> extends Comparable<State<I>> {

	/**
	 *
	 *
	 */
	public I getID();
}
