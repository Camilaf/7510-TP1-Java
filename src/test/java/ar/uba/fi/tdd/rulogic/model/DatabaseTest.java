package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.Database;
import ar.uba.fi.tdd.rulogic.model.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {

	private Database database = null;
	
	@Before
	public void setUp() {
		database = new Database();
		database.addFact("varon(juan).");
		database.addFact("varon(pepe).");
		database.addFact("mujer(maria).");
		database.addFact("padre(juan, pepe).");
		database.addRule("hijo(X, Y) :- varon(X), padre(Y, X).");
		database.addRule("hijo_de_juan(X) :- varon(X), padre(juan, X).");
	}
	
	@Test
	public void containsFact() {
	
		Assert.assertTrue(this.database.containsFact(new Query("varon(juan)")));
		Assert.assertTrue(this.database.containsFact(new Query("padre(juan, pepe)")));
		Assert.assertTrue(this.database.containsFact(new Query("padre(juan,pepe)")));
		Assert.assertTrue(this.database.containsFact(new Query("padre (juan,  pepe)")));
		Assert.assertFalse(this.database.containsFact(new Query("amigo(pepe, maria)")));
		Assert.assertFalse(this.database.containsFact(new Query("padrino(pepe, juan)")));
		Assert.assertTrue(this.database.containsFact(new Query("mujer(maria)")));
		Assert.assertFalse(this.database.containsFact(new Query("mujer(julieta)")));
	}
	
	@Test
	public void containsRule() {
	
		Assert.assertFalse(this.database.containsRule(new Query("varon(juan)")));
		Assert.assertFalse(this.database.containsRule(new Query("hijo(juan, pepe)")));
		Assert.assertTrue(this.database.containsRule(new Query("hijo(pepe, juan)")));
		Assert.assertFalse(this.database.containsRule(new Query("hijo(pepe, juan, roberto)")));
		Assert.assertFalse(this.database.containsRule(new Query("hijo(kevin, jorge)")));
		Assert.assertTrue(this.database.containsRule(new Query("hijo_de_juan(pepe)")));
		Assert.assertFalse(this.database.containsRule(new Query("hijo_de_juan(franco)")));
		Assert.assertFalse(this.database.containsRule(new Query("hija(ana, jorge)")));
	}

}
