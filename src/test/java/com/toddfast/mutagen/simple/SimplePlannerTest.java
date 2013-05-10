package com.toddfast.mutagen.simple;

import com.toddfast.mutagen.Mutation;
import com.toddfast.mutagen.Plan;
import com.toddfast.mutagen.Plan.Result;
import com.toddfast.mutagen.Planner;
import com.toddfast.mutagen.simple.test.mutations.java.Buffer;
import com.toddfast.mutagen.simple.test.mutations.java.Counter;
import com.toddfast.mutagen.simple.test.mutations.java.Mutation1;
import com.toddfast.mutagen.simple.test.mutations.java.Mutation2;
import com.toddfast.mutagen.simple.test.mutations.java.Mutation3;
import com.toddfast.mutagen.simple.test.mutations.java.MutationA;
import com.toddfast.mutagen.simple.test.mutations.java.MutationB;
import com.toddfast.mutagen.simple.test.mutations.java.MutationC;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 *
 * @author Todd Fast
 */
public class SimplePlannerTest {

	public SimplePlannerTest() {
	}


	@BeforeClass
	public static void setUpClass() {
	}


	@AfterClass
	public static void tearDownClass() {
	}


	@Before
	public void setUp() {
	}


	@After
	public void tearDown() {
	}


	/**
	 *
	 * 
	 */
	@Test
	public void testGetPlan() {

		List<Mutation<Integer>> mutations=new ArrayList<Mutation<Integer>>();

		mutations.add(new Mutation1());
		mutations.add(new Mutation2());
		mutations.add(new Mutation3());

		Planner planner=new SimplePlanner(mutations);

		Counter subject=new Counter(0);
		Plan plan=planner.getPlan(subject,null);

		Result result=plan.execute();

		assertEquals((int)subject.getCurrentState().getID(),3);
	}


	/**
	 *
	 *
	 */
	@Test
	public void testGetPlan2() {

		List<Mutation<Integer>> mutations=new ArrayList<Mutation<Integer>>();

		mutations.add(new Mutation1());
		mutations.add(new Mutation2());
		mutations.add(new Mutation3());

		Planner planner=new SimplePlanner(mutations);

		Counter subject=new Counter(1);
		Plan plan=planner.getPlan(subject,null);

		Result result=plan.execute();

		assertEquals((int)subject.getCurrentState().getID(),3);
	}


	/**
	 *
	 *
	 */
	@Test
	public void testGetPlan3() {

		List<Mutation<Integer>> mutations=new ArrayList<Mutation<Integer>>();

		mutations.add(new Mutation1());
		mutations.add(new Mutation2());
		mutations.add(new Mutation3());

		Planner planner=new SimplePlanner(mutations);

		Counter subject=new Counter(2);
		Plan plan=planner.getPlan(subject,null);

		Result result=plan.execute();

		assertEquals((int)subject.getCurrentState().getID(),3);
	}


	/**
	 *
	 *
	 */
	@Test
	public void testGetPlan4() {

		List<Mutation<Integer>> mutations=new ArrayList<Mutation<Integer>>();

		mutations.add(new Mutation1());
		mutations.add(new Mutation2());
		mutations.add(new Mutation3());

		Planner planner=new SimplePlanner(mutations);

		Counter subject=new Counter(3);
		Plan plan=planner.getPlan(subject,null);

		Result result=plan.execute();

		assertEquals((int)subject.getCurrentState().getID(),3);
	}


	/**
	 *
	 *
	 */
	@Test
	public void testGetPlan5() {

		List<Mutation<Integer>> mutations=new ArrayList<Mutation<Integer>>();

		mutations.add(new Mutation1());
		mutations.add(new Mutation2());
		mutations.add(new Mutation3());

		Planner planner=new SimplePlanner(mutations);

		Counter subject=new Counter(4);
		Plan plan=planner.getPlan(subject,null);

		Result result=plan.execute();

		assertEquals((int)subject.getCurrentState().getID(),4);
	}


	/**
	 *
	 *
	 */
	@Test
	public void testBuffer1() {

		List<Mutation<String>> mutations=new ArrayList<Mutation<String>>();

		mutations.add(new MutationA());
		mutations.add(new MutationB());
		mutations.add(new MutationC());

		Planner<String> planner=new SimplePlanner<String>(mutations);

		Buffer subject=new Buffer("");
		Plan<String> plan=planner.getPlan(subject,null);

		Result<String> result=plan.execute();

		assertEquals("abc",subject.getCurrentState().getID());
	}


	/**
	 *
	 *
	 */
	@Test
	public void testBuffer2() {

		List<Mutation<String>> mutations=new ArrayList<Mutation<String>>();

		mutations.add(new MutationA());
		mutations.add(new MutationB());
		mutations.add(new MutationC());

		Planner<String> planner=new SimplePlanner<String>(mutations);

		Buffer subject=new Buffer("a");
		Plan<String> plan=planner.getPlan(subject,null);

		Result<String> result=plan.execute();

		assertEquals("abc",subject.getCurrentState().getID());
	}
}
