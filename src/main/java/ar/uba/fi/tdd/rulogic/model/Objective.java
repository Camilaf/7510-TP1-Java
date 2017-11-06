package ar.uba.fi.tdd.rulogic.model;
import ar.uba.fi.tdd.rulogic.model.QueryParser;
import ar.uba.fi.tdd.rulogic.model.Query;
import java.util.*;

public class Objective {
	
	private String predicate;
	private String[] parameters;
	
	public Objective(String objective) {
		QueryParser queryParser = new QueryParser();
		this.predicate = queryParser.obtainClausePredicate(objective);
		this.parameters = queryParser.obtainQueryParameters(objective);
	}
	
	public String obtainPredicate() {
		return this.predicate;
	}
	
	public String[] obtainParameters() {
		return this.parameters;
	}
	
	/* Receives an ArrayList with parameters and builds a query string 
	 * using the predicate of the Objective and the given parameters. 
     */
	public String createQueryString(ArrayList<String> instantiatedParameters) {
		return this.predicate + "(" + String.join(",", instantiatedParameters) + ")";
	}
	
	/* Receives a mapping and returns a Query with the objective's 
	 * predicate and the parameters of the objective instantiated 
     * by the mapping. 
     */
	public Query build(Map<String, String> variableMapping) {
		ArrayList<String> instantiatedParameters = new ArrayList<String>();	
		for(String parameter : parameters) {
			String queryParameter = variableMapping.get(parameter);
			if (queryParameter != null) {
                instantiatedParameters.add(queryParameter);
            } else {
                instantiatedParameters.add(parameter);
            }
		}
		String query = createQueryString(instantiatedParameters);
		return new Query(query);
	}
}
