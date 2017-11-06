package ar.uba.fi.tdd.rulogic.model;
import ar.uba.fi.tdd.rulogic.model.RuleParser;
import ar.uba.fi.tdd.rulogic.model.Objective;
import ar.uba.fi.tdd.rulogic.model.Query;
import java.util.*;

public class Rule {
	
	private String predicate;
	private String[] variables;
	private ArrayList<Objective> objectives = new ArrayList<Objective>();
	
	public Rule(String rule) {
		RuleParser ruleParser = new RuleParser();
		predicate = ruleParser.obtainClausePredicate(rule);
		variables = ruleParser.obtainRuleVariables(rule);
		String[] objectivesList = ruleParser.obtainRuleObjectives(rule);
		addObjectives(objectivesList);
	}
	
	public String obtainPredicate() {
		return this.predicate;
	}
	
	public String[] obtainVariables() {
		return this.variables;
	}
	
	public ArrayList<Objective> obtainObjectives() {
		return this.objectives;
	}
	
	/* Receives a list of string objectives and adds each created Objective in 
	 * 'objectives' array. 
	 */
	private void addObjectives(String[] objectivesList) {
		for(String objective : objectivesList) {
			objectives.add(new Objective(objective));
		}
	}
	
	/* Receives a query and returns true if it has the same predicate
	 * as the rule. 
	 */
	public boolean samePredicate(Query query) {
		return this.predicate.equals(query.obtainPredicate());
	}
	
	/* Receives the parameters of a query and maps each rule variable
	 * to its corresponding query parameter. Returns the created map. 
	 */
	public Map<String, String> mapVariables(String[] queryParameters) {
		Map<String, String> variableMapping = new HashMap<String, String>();
		int position = 0;
		
		for (String variable : variables) {
			variableMapping.put(variable, queryParameters[position]);
			position++;
		}
		
		return variableMapping;
	}
}
