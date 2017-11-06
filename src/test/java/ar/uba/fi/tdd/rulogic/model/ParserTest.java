package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.Parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {

	private Parser parser = new Parser();


	@Test
	public void obtainClausePredicateTest() {
		
		Assert.assertTrue(this.parser.obtainClausePredicate("varon (hector)").equals("varon"));
		Assert.assertTrue(this.parser.obtainClausePredicate("padre_de(pedro, rodrigo)").equals("padre_de"));
		Assert.assertTrue(this.parser.obtainClausePredicate("hijo(X,Y):-varon(X),padre(Y,X).").equals("hijo"));
		Assert.assertTrue(this.parser.obtainClausePredicate("subtract(X,Y,Z):-add(Y,Z,X).").equals("subtract"));
		Assert.assertTrue(this.parser.obtainClausePredicate("varon (hector)").equals("varon"));
		Assert.assertTrue(this.parser.removeSpaces("varon (hector)").equals("varon(hector)"));
	}
	
	@Test
	public void removeSpacesTest() {
		
		Assert.assertTrue(this.parser.removeSpaces("hijo(X, Y) :- varon(X), padre(Y, X).").equals("hijo(X,Y):-varon(X),padre(Y,X)."));
		Assert.assertTrue(this.parser.removeSpaces("varon   (hector)").equals("varon(hector)"));
	}

}
