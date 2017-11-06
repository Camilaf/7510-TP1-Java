package ar.uba.fi.tdd.rulogic.model;

public class Validator {

	/* Receives a string 'clause' and indicates whether 
	 * it is a valid fact or not. 
	 */
    public boolean isValidFact(String clause) {
        String factPattern = "^([a-z]+[a-z_]*)\\(([a-z0-9]+)(,[a-z0-9]+)*\\)\\.$";
        return clause.matches(factPattern);
    }
    
	/* Receives a string 'clause' and indicates whether 
	 * it is a valid rule or not. 
	 */
    public boolean isValidRule(String clause) {
        String rulePattern = "^([a-z]+[a-z_]*)\\(([A-Z]+)(,[A-Z]+)*\\):-([a-z]+[a-z-]*)\\((\\w+)(,\\w+)*\\)(,([a-z]+[a-z-]*)\\((\\w+)(,\\w+)*\\))*\\.$";
        return clause.matches(rulePattern);
    }
    
    /* Receives a string 'clause' and indicates whether 
	 * it is a valid query or not. 
	 */
    public boolean isValidQuery(String clause) {
        String queryPattern = "^([a-z]+[a-z_]*)\\(([a-z0-9]+)(,[a-z0-9]+)*\\)$";
        return clause.matches(queryPattern);
    }
}
