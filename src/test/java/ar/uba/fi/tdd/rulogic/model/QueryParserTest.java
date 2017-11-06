package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.QueryParser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class QueryParserTest {

	private QueryParser queryParser = new QueryParser();


	@Test
	public void obtainQueryParametersTest() {
		String[] parametersTest1 = {"hector"};
		Assert.assertTrue(Arrays.equals(this.queryParser.obtainQueryParameters("varon(hector)"), parametersTest1));
		
		String[] parametersTest2 = {"pedro", "rodrigo"};
		Assert.assertTrue(Arrays.equals(this.queryParser.obtainQueryParameters("padre_de(pedro, rodrigo)"), parametersTest2));
		
		String[] parametersTest3 = {"kevin", "2"};
		Assert.assertTrue(Arrays.equals(this.queryParser.obtainQueryParameters("edad (kevin, 2)"), parametersTest3));
		
		String[] parametersTest4 = {"juana"};
		Assert.assertTrue(Arrays.equals(this.queryParser.obtainQueryParameters("mujer(juana)"), parametersTest4));
		
		String[] parametersTest5 = {"juan", "bren", "agus"};
		Assert.assertTrue(Arrays.equals(this.queryParser.obtainQueryParameters("trillizos(juan,bren,agus)"), parametersTest5));
	}

}
