package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.Objective;
import ar.uba.fi.tdd.rulogic.model.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ObjectiveTest {

	private Objective objective = new Objective("padre(Y, X)");


	@Test
	public void obtainPredicateTest() {
		Assert.assertTrue(this.objective.obtainPredicate().equals("padre"));
	}
	
	@Test
	public void obtainParametersTest() {
		String[] parameters = {"Y", "X"};
		Assert.assertTrue(Arrays.equals(this.objective.obtainParameters(), parameters));
	}
	
	@Test
	public void createQueryStringTest() {
		ArrayList<String> instantiatedParameters = new ArrayList<String>();
		instantiatedParameters.add("kevin");
		instantiatedParameters.add("lean");
		//Query query1 = new Query("padre(hector, juan)");
		Assert.assertTrue(this.objective.createQueryString(instantiatedParameters).equals("padre(kevin,lean)"));
	}
	
	@Test
	public void buildTest() {
		Map<String, String> variableMapping = new HashMap<String, String>();
		variableMapping.put("X", "Pedro");
		variableMapping.put("Y", "Pepe");
		
		Query newQuery = this.objective.build(variableMapping);
		String[] parameters = {"Pepe", "Pedro"};
		Assert.assertTrue(newQuery.obtainPredicate().equals("padre"));
		Assert.assertTrue(Arrays.equals(newQuery.obtainParameters(), parameters));
	}

}
