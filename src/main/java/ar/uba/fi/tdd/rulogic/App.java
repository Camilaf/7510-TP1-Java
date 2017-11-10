package ar.uba.fi.tdd.rulogic;
import ar.uba.fi.tdd.rulogic.model.KnowledgeBase;
import java.io.*;

/**
 * Console application.
 *
 */
public class App
{	
	public static void main (String[] args) throws Exception {
		if (args.length != 1) {
			System.out.println("Please include a path to the database file.");
			return;
		}
		
		String pathToDatabaseFile = args[0];		
		String line = null;
		KnowledgeBase knowledgeBase = new KnowledgeBase();
		
		knowledgeBase.parseDatabase(pathToDatabaseFile);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! I shall answer all your questions!");
		System.out.println("Please enter your query or type 'quit' to exit the application:");
		line = bufferedReader.readLine();
		while(!line.equals("quit")) {
			boolean queryAnswer = knowledgeBase.answer(line);
			System.out.println(queryAnswer);
			System.out.println("Please enter your next query or type 'quit' to exit the application:");
			line = bufferedReader.readLine();
		}
	}
}
