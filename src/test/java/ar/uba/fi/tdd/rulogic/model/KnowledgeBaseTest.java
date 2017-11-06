package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.KnowledgeBase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KnowledgeBaseTest {

	private KnowledgeBase knowledgeBase = new KnowledgeBase();


	@Test
	public void test() throws Exception {
		
		this.knowledgeBase.parseDatabase("./src/main/resources/rules.db");
		Assert.assertTrue(this.knowledgeBase.answer("varon (hector)"));
		Assert.assertTrue(this.knowledgeBase.answer("hijo(pepe, juan)"));
		Assert.assertFalse(this.knowledgeBase.answer("padrino(pepe, juan)"));
		Assert.assertFalse(this.knowledgeBase.answer("hijo(pepe, javier)"));
	}
	
	@Test
	public void dbNumberTest() throws Exception {
		
		this.knowledgeBase.parseDatabase("./src/main/resources/number.db");
		Assert.assertTrue(this.knowledgeBase.answer("add(one, one, two)"));
		Assert.assertFalse(this.knowledgeBase.answer("divide(two, one)"));
		Assert.assertFalse(this.knowledgeBase.answer("add(two, one, one)"));
		Assert.assertFalse(this.knowledgeBase.answer("add(two, one)"));
		Assert.assertFalse(this.knowledgeBase.answer("subtract(one, one, two)"));
		Assert.assertFalse(this.knowledgeBase.answer("subtract(one, one)"));
		Assert.assertTrue(this.knowledgeBase.answer("subtract(two, one, one)"));
	}

	@Test
	public void invalidQueryTest() throws Exception {
		
		this.knowledgeBase.parseDatabase("./src/main/resources/number.db");
		try {
			this.knowledgeBase.answer("add()");
    
		} catch (Exception ex) {
			Assert.assertTrue(ex.getMessage().equals("Invalid query: add()"));
		}
	}
	
	@Test
	public void invalidEntryTest() {
		try {
			this.knowledgeBase.parseDatabase("./src/main/resources/invalid.db");
    
		} catch (Exception ex) {
			Assert.assertTrue(ex.getMessage().equals("Invalid entry in database: padre."));
		}
	}

}
