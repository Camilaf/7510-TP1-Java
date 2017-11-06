package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

	private Validator validator = new Validator();

	@Test
	public void isValidFactTest() {

		Assert.assertTrue(this.validator.isValidFact("varon(javier)."));
		Assert.assertTrue(this.validator.isValidFact("primo(juan,maria)."));
		Assert.assertFalse(this.validator.isValidFact("primo(juan,maria)"));
		Assert.assertFalse(this.validator.isValidFact("primo(juan,)."));
		Assert.assertFalse(this.validator.isValidFact("primo(,maria)."));
		Assert.assertFalse(this.validator.isValidFact("(juan,maria)."));
		Assert.assertFalse(this.validator.isValidFact("primo()."));
		Assert.assertFalse(this.validator.isValidFact("primo."));
		Assert.assertFalse(this.validator.isValidFact("PRIMO(juan,maria)."));
		Assert.assertTrue(this.validator.isValidFact("es_primo_de(juan,maria)."));
		Assert.assertTrue(this.validator.isValidFact("edad(pepe,2)."));
		Assert.assertFalse(this.validator.isValidFact("primo(juan,X)."));
		Assert.assertFalse(this.validator.isValidFact("mujer(X)."));
		Assert.assertFalse(this.validator.isValidFact("hijo_de(X,Y):-varon(X),padre(Y,X)."));
	}
	
	@Test
	public void isValidRuleTest() {

		Assert.assertTrue(this.validator.isValidRule("hijo(X,Y):-varon(X),padre(Y,X)."));
		Assert.assertTrue(this.validator.isValidRule("hijo_de(X,Y):-varon(X),padre(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("hijo(X,Y):-varon(X),padre(Y,X)"));
		Assert.assertFalse(this.validator.isValidRule("hijo(,Y):-varon(X),padre(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("hijo(X,):-varon(X),padre(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("hijo:-varon(X),padre(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("(X,Y):-varon(X),padre(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("_(X,Y):-varon(X),padre(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("hijo(X,Y):varon(X),padre(Y,X)."));
		Assert.assertTrue(this.validator.isValidRule("hijo_de_kevin(X):-varon(X),padre(kevin,X)."));
		Assert.assertFalse(this.validator.isValidRule("Hijo(X,Y):-varon(X),padre(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("hijo():-varon(X),padre(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("hijo(X,Y):-,padre(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("hijo(X,Y):-varon(X),."));
		Assert.assertFalse(this.validator.isValidRule("hijo(X,Y):-varon(),padre(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("hijo(X,Y):-varon(X),padre."));
		Assert.assertFalse(this.validator.isValidRule("hijo(X,Y):-varon(X),(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("hijo(X,Y):-VARON(X),padre(Y,X)."));
		Assert.assertFalse(this.validator.isValidRule("hijo(kevin,Y):-varon(kevin),padre(Y,kevin)."));
		Assert.assertFalse(this.validator.isValidRule("hijo."));
		Assert.assertFalse(this.validator.isValidRule("hijo(kevin,Y)varon(kevin),padre(Y,kevin)."));
		Assert.assertFalse(this.validator.isValidRule("varon(kevin)."));
	}
	
	@Test
	public void isValidQueryTest() {

		Assert.assertTrue(this.validator.isValidQuery("varon(javier)"));
		Assert.assertTrue(this.validator.isValidQuery("primo(juan,maria)"));
		Assert.assertFalse(this.validator.isValidQuery("primo(juan,maria)."));
		Assert.assertFalse(this.validator.isValidQuery("primo(juan,)"));
		Assert.assertFalse(this.validator.isValidQuery("primo(,maria)"));
		Assert.assertFalse(this.validator.isValidQuery("(juan,maria)"));
		Assert.assertFalse(this.validator.isValidQuery("primo()"));
		Assert.assertFalse(this.validator.isValidQuery("primo"));
		Assert.assertFalse(this.validator.isValidQuery("PRIMO(juan,maria)"));
		Assert.assertTrue(this.validator.isValidQuery("es_primo_de(juan,maria)"));
		Assert.assertTrue(this.validator.isValidQuery("edad(pepe,2)"));
		Assert.assertFalse(this.validator.isValidQuery("primo(juan,X)"));
		Assert.assertFalse(this.validator.isValidQuery("mujer(X)"));
		Assert.assertFalse(this.validator.isValidQuery("suma3(1,2)"));
	}
}
