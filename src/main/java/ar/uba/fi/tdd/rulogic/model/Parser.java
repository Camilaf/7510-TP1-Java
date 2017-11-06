package ar.uba.fi.tdd.rulogic.model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

	protected String removeSpaces(String clause) {
		return clause.replace(" ", "");
	}
	
	/* Returns the predicate of the given string 'clause'. */
	public String obtainClausePredicate(String clause) {
		String clausePredicatePattern = "^[a-z]+[a-z_]*";
		int predicateIndex = 0;
		Pattern predicate = Pattern.compile(clausePredicatePattern);        
		Matcher m = predicate.matcher(clause);
		m.find();
		return m.group(predicateIndex);		
	}
	
	/* Returns the parameters of the given string 'clause', according to 
	 * the regular expression.
	 */
	protected String[] obtainClauseParameters(String clause, String clauseParametersPattern) {
		int parametersIndex = 1;
		String parameterSeparator = ",";
		Pattern parameters = Pattern.compile(clauseParametersPattern);
		Matcher m = parameters.matcher(clause);
		m.find();
		String parameterString = m.group(parametersIndex);
		return parameterString.split(parameterSeparator);
	}
}
