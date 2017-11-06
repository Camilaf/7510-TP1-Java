package ar.uba.fi.tdd.rulogic.model;
import ar.uba.fi.tdd.rulogic.model.QueryParser;

public class Query {
	
	private String predicate;
	private String[] parameters;
	
	public Query(String query) {
		QueryParser queryParser = new QueryParser();
		this.predicate = queryParser.obtainClausePredicate(query);
		this.parameters = queryParser.obtainQueryParameters(query);
	}
	
	public String obtainPredicate() {
		return this.predicate;
	}
	
	public String[] obtainParameters() {
		return this.parameters;
	}
}
