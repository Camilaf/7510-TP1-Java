package ar.uba.fi.tdd.rulogic.model;
import ar.uba.fi.tdd.rulogic.model.Parser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RuleParser extends Parser {

	/* Returns the variables of the given rule. */
    public String[] obtainRuleVariables(String rule) {
    	String cleanRule = removeSpaces(rule);
        String ruleVariablesPattern = "^.*\\((.*)\\):-.*$";
        return obtainClauseParameters(cleanRule, ruleVariablesPattern);
    }
    
    /* Returns the objectives of the given rule. */
    public String[] obtainRuleObjectives(String rule) {
    	String cleanRule = removeSpaces(rule);
        String ruleObjectivesPattern = "^.*\\(.*\\):-(.*).$";
        String objectiveSeparatorPattern = "(?<=\\)),";
        int objectivesIndex = 1;
		Pattern objectives = Pattern.compile(ruleObjectivesPattern);        
		Matcher m = objectives.matcher(cleanRule);
		m.find();
		return m.group(objectivesIndex).split(objectiveSeparatorPattern);
    }
}
