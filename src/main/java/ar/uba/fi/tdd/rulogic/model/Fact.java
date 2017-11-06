package ar.uba.fi.tdd.rulogic.model;
import ar.uba.fi.tdd.rulogic.model.FactParser;
import ar.uba.fi.tdd.rulogic.model.Query;
import java.util.Arrays;

public class Fact {
	
	private String predicate;
	private String[] parameters;
	
	public Fact(String fact) {
		FactParser factParser = new FactParser();
		this.predicate = factParser.obtainClausePredicate(fact);
		this.parameters = factParser.obtainFactParameters(fact);
	}
	
	public String obtainPredicate() {
		return this.predicate;
	}
	
	public String[] obtainParameters() {
		return this.parameters;
	}
	
	/* Receives a query and returns true if it has the same predicate
	 * as the fact. 
	 */
	public boolean samePredicate(Query query) {
		return this.predicate.equals(query.obtainPredicate());
	}
	
	/* Receives a query and returns true if it has the same parameters
	 * as the fact. 
	 */
	public boolean sameParameters(Query query) {
		return Arrays.equals(this.parameters, query.obtainParameters());
	}
	
	/* Receives a query and returns true if it has the same predicate and 
	 * parameters as the fact. 
	 */
	public boolean equalTo(Query query) {
		return this.samePredicate(query) && this.sameParameters(query);
	}
}
