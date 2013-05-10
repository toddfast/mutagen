package com.toddfast.mutagen.simple;

import com.toddfast.mutagen.Mutation;
import com.toddfast.mutagen.Mutation.Context;
import com.toddfast.mutagen.MutationException;
import com.toddfast.mutagen.Plan;
import com.toddfast.mutagen.Plan.Result;
import com.toddfast.mutagen.Planner;
import com.toddfast.mutagen.State;
import com.toddfast.mutagen.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 
 * @author Todd Fast
 */
public class SimplePlanner<I extends Comparable<I>> implements Planner<I>  {

	/**
	 *
	 *
	 */
	public SimplePlanner(Collection<Mutation<I>> allMutations) {
		this(allMutations,null);
	}


	/**
	 *
	 *
	 */
	public SimplePlanner(Collection<Mutation<I>> allMutations,
			Comparator<Mutation<I>> comparator) {

		super();

		this.mutations=new ArrayList<Mutation<I>>(allMutations);
		if (comparator!=null) {
			Collections.sort(this.mutations,comparator);
		}
	}


	/**
	 *
	 *
	 */
	@Override
	public Plan<I> getPlan(Subject<I> subject, State<I> desiredEndState) {

		List<Mutation<I>> subjectMutations=
			new ArrayList<Mutation<I>>(mutations);

		// Filter out the mutations that are unacceptable to the subject
		for (Iterator<Mutation<I>> i=subjectMutations.iterator();
				i.hasNext(); ) {

			Mutation<I> mutation=i.next();
			if (!subject.accept(mutation.getResultingState())) {
				i.remove();
			}
		}

		return new SimplePlan(subject,subjectMutations);
	}


	/**
	 *
	 *
	 */
	private SimpleResult executePlan(SimplePlan plan) {

		List<Mutation<I>> completedMutations=new ArrayList<Mutation<I>>();
		List<Mutation<I>> remainingMutations=
			new ArrayList<Mutation<I>>(plan.mutations);
		MutationException exception=null;

		Context context=new SimpleContext(plan.getSubject());

		Mutation<I> mutation;
		State<I> lastState=null;
		for (Iterator<Mutation<I>>
				i=remainingMutations.iterator(); i.hasNext(); ) {

			mutation=i.next();

			try {
				lastState=mutation.mutate(context);

				// Add to the completed list, remove from remaining list
				completedMutations.add(mutation);
				i.remove();
			}
			catch (RuntimeException e) {
				exception=new MutationException("Exception executing "+
					"mutation for state \""+mutation.getResultingState()+
					"\"",e);
				break;
			}
		}

		return new SimpleResult(plan,plan.getSubject(),
			completedMutations,remainingMutations,lastState,exception);
	}




	////////////////////////////////////////////////////////////////////////////
	// Types
	////////////////////////////////////////////////////////////////////////////

	/**
	 *
	 *
	 */
	public class SimplePlan implements com.toddfast.mutagen.Plan<I> {

		/**
		 *
		 *
		 */
		private SimplePlan(Subject<I> subject, List<Mutation<I>> mutations) {
			super();
			this.subject=subject;
			this.mutations=mutations;
		}

		/**
		 *
		 *
		 */
		@Override
		public Subject<I> getSubject() {
			return subject;
		}

		/**
		 *
		 *
		 */
		@Override
		public List<Mutation<I>> getMutations() {
			return Collections.unmodifiableList(mutations);
		}

		/**
		 *
		 *
		 */
		@Override
		public Result<I> execute()
				throws MutationException {
			return SimplePlanner.this.executePlan(this);
		}

		private Subject<I> subject;
		private List<Mutation<I>> mutations;
	}




	////////////////////////////////////////////////////////////////////////////
	// Types
	////////////////////////////////////////////////////////////////////////////

	/**
	 *
	 *
	 */
	public class SimpleResult implements com.toddfast.mutagen.Plan.Result<I> {

		/**
		 *
		 *
		 */
		private SimpleResult(SimplePlan plan, 
				Subject<I> subject,
				List<Mutation<I>> completedMutations,
				List<Mutation<I>> remainingMutations,
				State<I> lastState,
				MutationException exception) {
			super();
			this.plan=plan;
			this.subject=subject;
			this.completedMutations=completedMutations;
			this.remainingMutations=remainingMutations;
			this.lastState=lastState;
			this.exception=exception;
		}

		/**
		 *
		 *
		 */
		@Override
		public com.toddfast.mutagen.Plan<I> getPlan() {
			return plan;
		}

		/**
		 *
		 *
		 */
		@Override
		public boolean isMutationComplete() {
			return remainingMutations.isEmpty();
		}


		/**
		 *
		 *
		 */
		@Override
		public State<I> getLastState() {
			return lastState;
		}


		/**
		 *
		 *
		 */
		@Override
		public List<Mutation<I>> getCompletedMutations() {
			return completedMutations;
		}


		/**
		 *
		 *
		 */
		@Override
		public List<Mutation<I>> getRemainingMutations() {
			return remainingMutations;
		}


		/**
		 *
		 *
		 */
		@Override
		public MutationException getException() {
			return exception;
		}


		private SimplePlan plan;
		private Subject<I> subject;
		private List<Mutation<I>> completedMutations;
		private List<Mutation<I>> remainingMutations;
		private State<I> lastState;
		private MutationException exception;
	}




	////////////////////////////////////////////////////////////////////////////
	// Fields
	////////////////////////////////////////////////////////////////////////////

	public static final Comparator<Mutation<?>> COMPARATOR=
		new Comparator<Mutation<?>>() {
			@Override
			public int compare(Mutation m1, Mutation m2) {
				return m1.getResultingState().compareTo(m2.getResultingState());
			}
		};

	private List<Mutation<I>> mutations;
}
