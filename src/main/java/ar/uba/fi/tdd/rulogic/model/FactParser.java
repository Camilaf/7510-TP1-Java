package ar.uba.fi.tdd.rulogic.model;
import ar.uba.fi.tdd.rulogic.model.Parser;

public class FactParser extends Parser {

	/* Returns the parameters of the given fact. */
	public String[] obtainFactParameters(String fact) {
		String cleanFact = removeSpaces(fact);
		String factParametersPattern = "^.*\\((.*)\\)\\.$";
		return obtainClauseParameters(cleanFact, factParametersPattern);
	}
}
