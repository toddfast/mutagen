package com.toddfast.mutagen;

import java.util.List;

/**
 * A prepared plan for mutating the target subject through a sequence of states
 * 
 * @author Todd Fast
 */
public interface Plan<I extends Comparable<I>> {

	/**
	 *
	 *
	 */
	public Subject<I> getSubject();


	/**
	 *
	 *
	 */
	public Coordinator<I> getCoordinator();


	/**
	 *
	 *
	 */
	public List<Mutation<I>> getMutations();


	/**
	 *
	 *
	 */
	public Result<I> execute()
		throws MutationException;




	////////////////////////////////////////////////////////////////////////////
	// Types
	////////////////////////////////////////////////////////////////////////////

	/**
	 *
	 *
	 */
	public static interface Result<I extends Comparable<I>> {

		/**
		 *
		 *
		 */
		public Plan<I> getPlan();


		/**
		 *
		 *
		 */
		public boolean isMutationComplete();


		/**
		 *
		 *
		 */
		public <I extends Comparable<I>> I getLastState();


		/**
		 *
		 *
		 */
		public List<Mutation<I>> getCompletedMutations();


		/**
		 *
		 *
		 */
		public List<Mutation<I>> getRemainingMutations();


		/**
		 *
		 *
		 */
		public MutationException getException();
	}
}
