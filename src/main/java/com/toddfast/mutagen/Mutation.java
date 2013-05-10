package com.toddfast.mutagen;

/**
 *
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
	public State<I> mutate(Context context)
		throws MutationException;




	////////////////////////////////////////////////////////////////////////////
	// Types
	////////////////////////////////////////////////////////////////////////////

	/**
	 *
	 *
	 */
	public static interface Context {

		/**
		 *
		 *
		 */
		public Subject getSubject();

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
