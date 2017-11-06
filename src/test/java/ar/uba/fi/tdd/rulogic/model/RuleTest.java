package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.Rule;
import ar.uba.fi.tdd.rulogic.model.Query;
import ar.uba.fi.tdd.rulogic.model.Objective;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.*;

public class RuleTest {

	private Rule rule = new Rule("hijo(X, Y) :- varon(X), padre(Y, X).");


	@Test
	public void obtainPredicateTest() {
		Assert.assertTrue(this.rule.obtainPredicate().equals("hijo"));
	}
	
	@Test
	public void obtainVariablesTest() {
		String[] variables = {"X", "Y"};
		Assert.assertTrue(Arrays.equals(this.rule.obtainVariables(), variables));
	}
	
	@Test
	public void obtainObjectivesTest() {
		ArrayList<Objective> objectives = new ArrayList<Objective>();
		objectives.add(new Objective("varon(X)"));
		objectives.add(new Objective("padre(Y, X)"));
		ArrayList<Objective> ruleObjectives = this.rule.obtainObjectives();
		
		Assert.assertTrue(objectives.get(0).obtainPredicate().equals(ruleObjectives.get(0).obtainPredicate()));
		Assert.assertTrue(Arrays.equals(objectives.get(0).obtainParameters(), ruleObjectives.get(0).obtainParameters()));
		
		Assert.assertTrue(objectives.get(1).obtainPredicate().equals(ruleObjectives.get(1).obtainPredicate()));
		Assert.assertTrue(Arrays.equals(objectives.get(1).obtainParameters(), ruleObjectives.get(1).obtainParameters()));
	}

	@Test
	public void samePredicateTest() {
		Query query1 = new Query("hijo(hector, juan)");
		Assert.assertTrue(this.rule.samePredicate(query1));
		
		Query query2 = new Query("mujer(ana)");
		Assert.assertFalse(this.rule.samePredicate(query2));
	}
	
	@Test
	public void mapVariablesTest() {
		String[] queryParam = {"juan", "pepe"};
		Map<String, String> varMapping = this.rule.mapVariables(queryParam); 
		Assert.assertTrue(varMapping.get("X").equals("juan"));
		Assert.assertTrue(varMapping.get("Y").equals("pepe"));
	}

}
