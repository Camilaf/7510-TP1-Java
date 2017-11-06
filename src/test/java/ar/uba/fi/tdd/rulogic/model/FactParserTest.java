package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.FactParser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class FactParserTest {

	private FactParser factParser = new FactParser();


	@Test
	public void obtainFactParametersTest() {
		String[] parametersTest1 = {"hector"};
		Assert.assertTrue(Arrays.equals(this.factParser.obtainFactParameters("varon(hector)."), parametersTest1));
		
		String[] parametersTest2 = {"pedro", "rodrigo"};
		Assert.assertTrue(Arrays.equals(this.factParser.obtainFactParameters("padre_de(pedro, rodrigo)."), parametersTest2));
		
		String[] parametersTest3 = {"juan", "pepe"};
		Assert.assertTrue(Arrays.equals(this.factParser.obtainFactParameters("padre (juan,pepe)."), parametersTest3));
		
		String[] parametersTest4 = {"juana"};
		Assert.assertTrue(Arrays.equals(this.factParser.obtainFactParameters("mujer(juana)."), parametersTest4));
		
		String[] parametersTest5 = {"juan", "bren", "agus"};
		Assert.assertTrue(Arrays.equals(this.factParser.obtainFactParameters("trillizos(juan,bren,agus)."), parametersTest5));
	}

}

