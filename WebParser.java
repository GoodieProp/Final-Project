/**
 * 
 */

/**
 * @author Xavier Gonzalez
 *
 */
public class WebParser {

	public static Scores parseWebsite(String line) {
		
	String date = "";
	String location = "";
	String result = "";
	
	System.out.println(line);
	
	
	return new Scores(date, location, result);
	}
}
