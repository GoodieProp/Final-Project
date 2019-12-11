import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * It scrapes the web
 * @author xavie
 *
 */
public class WebScraper {

	public static ArrayList<Scores> screenScaper(String url) {
		String line;
		String parts[];
		ArrayList<Scores> scores = new ArrayList<Scores>();
		
		try {
			URL link = new URL(url);
			Scanner linksc = new Scanner(link.openStream());
			while (linksc.hasNextLine()) {
				line = linksc.nextLine();
				if (line == null) {
					linksc.nextLine();
				} else {
					
				}
				//if (line.substring(58,69) == null) {
					//scores.add(WebParser.parseWebsite(line.substring(58,69)));
					//System.out.println(line.substring(1,2).trim());
				System.out.println(line);
				}
				//System.out.println(line.substring(1,2).trim());
			
				
			
			linksc.close();
			return scores;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Could not connect to the website.");
			return null;
		}
	}
	
}
