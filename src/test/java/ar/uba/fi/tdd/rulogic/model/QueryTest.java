package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class QueryTest {

	private Query query = new Query("amigo(leo, marti)");


	@Test
	public void obtainPredicateTest() {
		Assert.assertTrue(this.query.obtainPredicate().equals("amigo"));
	}
	
	@Test
	public void obtainParametersTest() {
		String[] parameters1 = {"leo", "marti"};
		Assert.assertTrue(Arrays.equals(this.query.obtainParameters(), parameters1));
		
		String[] parameters2 = {"marti", "leo"};
		Assert.assertFalse(Arrays.equals(this.query.obtainParameters(), parameters2));
	}
}
