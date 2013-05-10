package com.toddfast.mutagen.simple;

import com.toddfast.mutagen.State;

/**
 *
 * @author Todd Fast
 */
public class SimpleState<I extends Comparable<I>> implements State<I> {

	/**
	 *
	 *
	 */
	public SimpleState(I id) {
		super();
		this.id=id;
	}


	/**
	 *
	 *
	 */
	@Override
	public I getID() {
		return id;
	}


	/**
	 *
	 *
	 */
	@Override
	public int compareTo(State<I> other) {
		return id.compareTo(other.getID());
	}



	////////////////////////////////////////////////////////////////////////////
	// Fields
	////////////////////////////////////////////////////////////////////////////

	private I id;
}
