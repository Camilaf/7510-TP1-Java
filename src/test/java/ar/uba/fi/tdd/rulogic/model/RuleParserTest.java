package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.RuleParser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class RuleParserTest {

	private RuleParser ruleParser = new RuleParser();


	@Test
	public void obtainRuleVariables() {
		String[] parametersTest1 = {"X", "Y"};
		Assert.assertTrue(Arrays.equals(this.ruleParser.obtainRuleVariables("hijo(X,Y):-varon(X),padre(Y,X)."), parametersTest1));
		
		String[] parametersTest2 = {"X", "Y", "Z"};
		Assert.assertTrue(Arrays.equals(this.ruleParser.obtainRuleVariables("subtract(X, Y, Z) :- add(Y, Z, X)."), parametersTest2));
		
		String[] parametersTest3 = {"X", "Y", "Z"};
		Assert.assertTrue(Arrays.equals(this.ruleParser.obtainRuleVariables("amigos(X,Y,Z):-amigo(X,Y),amigo(X,Z),amigo(Y,X),amigo(Y,Z),amigo(Z,X),amigo(Z,Y)."), parametersTest3));
	}
	
	@Test
	public void obtainRuleObjectivesTest() {
		String[] parametersTest1 = {"varon(X)", "padre(Y,X)"};
		Assert.assertTrue(Arrays.equals(this.ruleParser.obtainRuleObjectives("hijo(X,Y):-varon(X),padre(Y,X)."), parametersTest1));
		
		String[] parametersTest2 = {"add(Y,Z,X)"};
		Assert.assertTrue(Arrays.equals(this.ruleParser.obtainRuleObjectives("subtract(X, Y, Z) :- add(Y, Z, X)."), parametersTest2));
		
		String[] parametersTest3 = {"amigo(X,Y)", "amigo(X,Z)", "amigo(Y,X)", "amigo(Y,Z)", "amigo(Z,X)", "amigo(Z,Y)"};
		Assert.assertTrue(Arrays.equals(this.ruleParser.obtainRuleObjectives("amigos(X,Y,Z):-amigo(X,Y),amigo(X,Z),amigo(Y,X),amigo(Y,Z),amigo(Z,X),amigo(Z,Y)."), parametersTest3));
	}


}

