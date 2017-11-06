package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.Fact;
import ar.uba.fi.tdd.rulogic.model.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class FactTest {

	private Fact fact = new Fact("padre (juan, pepe).");


	@Test
	public void obtainPredicateTest() {
		Assert.assertTrue(this.fact.obtainPredicate().equals("padre"));
	}
	
	@Test
	public void obtainParametersTest() {
		String[] parameters = {"juan", "pepe"};
		Assert.assertTrue(Arrays.equals(this.fact.obtainParameters(), parameters));
	}
	
	@Test
	public void samePredicateTest() {
		Query query1 = new Query("padre(hector, juan)");
		Assert.assertTrue(this.fact.samePredicate(query1));
		
		Query query2 = new Query("mujer(ana)");
		Assert.assertFalse(this.fact.samePredicate(query2));
	}
	
	@Test
	public void sameParametersTest() {
		Query query1 = new Query("padre(hector, juan)");
		Assert.assertFalse(this.fact.sameParameters(query1));
		
		Query query2 = new Query("primo(juan,pepe)");
		Assert.assertTrue(this.fact.sameParameters(query2));
		
		Query query3 = new Query("mujer(ana)");
		Assert.assertFalse(this.fact.sameParameters(query3));
	}
	
	@Test
	public void equalToTest() {
		Query query1 = new Query("padre(hector, juan)");
		Assert.assertFalse(this.fact.equalTo(query1));
		
		Query query2 = new Query("primo(juan,pepe)");
		Assert.assertFalse(this.fact.equalTo(query2));
		
		Query query3 = new Query("mujer(ana)");
		Assert.assertFalse(this.fact.equalTo(query3));
		
		Query query4 = new Query("padre(juan,pepe)");
		Assert.assertTrue(this.fact.equalTo(query4));
		
		Query query5 = new Query("padre(pepe, juan)");
		Assert.assertFalse(this.fact.equalTo(query5));
	}

}
