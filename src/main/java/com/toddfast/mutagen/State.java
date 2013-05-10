package com.toddfast.mutagen;

/**
 *
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
