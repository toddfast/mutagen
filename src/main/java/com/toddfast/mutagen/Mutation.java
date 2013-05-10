package com.toddfast.mutagen;

/**
 * Represents a single change that can be made to a subject, identified
 * unambiguously by a state.
 * 
 * @author Todd Fast
 */
public interface Mutation<I extends Comparable<I>> {

	/**
	 *
	 *
	 */
	public State<I> getResultingState();


	/**
	 *
	 *
	 */
	public void mutate(Context context)
		throws MutagenException;




	////////////////////////////////////////////////////////////////////////////
	// Types
	////////////////////////////////////////////////////////////////////////////

	/**
	 * Context provided to an executing mutation
	 *
	 */
	public static interface Context {

		/**
		 *
		 *
		 */
		public Subject<?> getSubject();


		/**
		 *
		 *
		 */
		public Coordinator<?> getCoordinator();


		/**
		 *
		 *
		 */
		public void info(String message, Object... parameters);

		/**
		 *
		 *
		 */
		public void debug(String message, Object... parameters);

		/**
		 *
		 *
		 */
		public void error(String message, Object... parameters);
	}
}
