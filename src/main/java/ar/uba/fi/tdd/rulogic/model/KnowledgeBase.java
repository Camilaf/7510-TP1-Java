package ar.uba.fi.tdd.rulogic.model;
import ar.uba.fi.tdd.rulogic.model.Database;
import ar.uba.fi.tdd.rulogic.model.Validator;
import ar.uba.fi.tdd.rulogic.model.Query;
import java.io.*;

public class KnowledgeBase {
	
	private Database database = new Database();
	private Validator validator = new Validator();
	
	/* Receives a query string and returns true if the rules and facts
     * in the database imply query, false if not. If the query can't be
     * parsed, throws an Exception. 
     */
	public boolean answer(String query) throws Exception {
		String cleanQuery = query.replace(" ", "").replace("\t", "");
		if (!validator.isValidQuery(cleanQuery)) {
			throw new Exception("Invalid query: " + query);
		}
		
		Query newQuery = new Query(cleanQuery);
		return database.containsFact(newQuery) || database.containsRule(newQuery);
	}
	
	/* Receives the database file path and adds its clauses to the database. 
	 * If one clause can't be parsed, throws an Exception. 
	 */
	public void parseDatabase(String pathToDatabaseFile) throws Exception {
		String line = null;
		FileReader fileReader = new FileReader(pathToDatabaseFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		line = bufferedReader.readLine();
		try {
			while(line != null) {
				String cleanLine = line.replace(" ", "").replace("\t", "");
				if (validator.isValidFact(cleanLine)) {
					database.addFact(cleanLine);
				}
				else if (validator.isValidRule(cleanLine)) {
					database.addRule(cleanLine);
				}
				else {
					throw new Exception("Invalid entry in database: " + cleanLine);
				}
				line = bufferedReader.readLine();
			}   
		}
		
		finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		
	}

}
