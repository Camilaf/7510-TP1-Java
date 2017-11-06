package ar.uba.fi.tdd.rulogic.model;
import ar.uba.fi.tdd.rulogic.model.Fact;
import ar.uba.fi.tdd.rulogic.model.Rule;
import ar.uba.fi.tdd.rulogic.model.Query;
import java.util.*;

public class Database {

	public ArrayList<Fact> facts = new ArrayList<Fact>();
	public ArrayList<Rule> rules = new ArrayList<Rule>();
	
	/* Receives a parsed fact and adds its corresponding Fact object 
	 * to the facts ArrayList. 
	 */
	public void addFact(String clause) {
		Fact fact = new Fact(clause);
		this.facts.add(fact);
	}
	
	/* Receives a parsed rule and adds its corresponding Rule object 
	 * to the rules ArrayList. 
	 */
	public void addRule(String clause) {
		Rule rule = new Rule(clause);
		this.rules.add(rule);
	}
	
	/* Receives a Query fact and determines if it is stored in 
	 * the database. 
	 */
	public boolean containsFact(Query fact) {
		int numberOfFacts = facts.size();

		for (int i = 0; i < numberOfFacts; i++) {
			Fact dbFact = facts.get(i);
			if (dbFact.equalTo(fact)) {
				return true;
			}
		}
		return false;
	}
	
	/* Receives a rule and a query. If the query has the same number 
	 * of parameters as the rule, it verifies that all the objectives 
	 * of the rule are in the database and in that case returns true. 
	 */
	private boolean containsObjectives(Rule rule, Query query) {
		ArrayList<Objective> ruleObjectives = rule.obtainObjectives();
		int numberOfRuleObjectives = ruleObjectives.size();
		int numberOfRuleVariables = rule.obtainVariables().length;
		int numberOfQueryParameters = query.obtainParameters().length;
		
		if (numberOfRuleVariables != numberOfQueryParameters) {
			return false;
		}    
		Map<String, String> variableMapping = rule.mapVariables(query.obtainParameters());
    
		for (int i = 0; i < numberOfRuleObjectives; i++) { 
			Objective objective = ruleObjectives.get(i);
			Query newQuery = objective.build(variableMapping);
            
			if (!this.containsFact(newQuery)) {
				return false;
			}
		}   
		return true;
	}
	
	/* Receives a Query rule and determines whether it is true 
	 * or false. 
	 */
	public boolean containsRule(Query rule) {
		int numberOfRules = rules.size();

		for (int i = 0; i < numberOfRules; i++) {
			Rule dbRule = rules.get(i);
			if (dbRule.samePredicate(rule) && this.containsObjectives(dbRule, rule)) {
				return true;
			}
		}
		return false;
	}
}
