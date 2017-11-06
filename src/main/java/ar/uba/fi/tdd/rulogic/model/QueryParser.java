package ar.uba.fi.tdd.rulogic.model;
import ar.uba.fi.tdd.rulogic.model.Parser;

public class QueryParser extends Parser {

	/* Returns the parameters of the given query. */
	public String[] obtainQueryParameters(String query) {
		String cleanQuery = removeSpaces(query);
		String queryParametersPattern = "^.*\\((.*)\\)$";
		return obtainClauseParameters(cleanQuery, queryParametersPattern);
	}
}
