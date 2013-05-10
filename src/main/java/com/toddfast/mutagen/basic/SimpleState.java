package com.toddfast.mutagen.basic;

import com.toddfast.mutagen.State;

/**
 * A simple {@link State} implementation that encapsulates a specified ID.
 * 
 * @author Todd Fast
 */
public final class SimpleState<I extends Comparable<I>> implements State<I> {

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
