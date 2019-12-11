import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



/**
 * 
 */

/**
 * @author xavie
 *
 */
public class SaveTo {

	public static boolean writeToText(File f, ArrayList<Scores> score) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (Scores s : score) {
				pw.println(s);
			}
			pw.close();
			System.out.println("\nThe scores were written successfully.");
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static boolean writeToJSON(File f, ArrayList<Scores> score) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			
			JSONObject sObj;
			JSONArray array = new JSONArray();
			for (Scores s : score) {
				
				sObj = new JSONObject();
				sObj.put("Date", s.getDate());
				sObj.put("Location", s.getLocation());
				sObj.put("Result", s.getResult());
				
				array.add(sObj);
			}
			JSONObject outer = new JSONObject();
			outer.put("Lewis University Soccer Scores 2019", array);
			pw.println(outer.toJSONString());
			pw.close();
			
			System.out.println("\nThe scores were written successfully.");
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
}
