/**
 * 
 */

/**
 * @author xavie
 *
 */
public class Scores {

	private String title;
	private String date;
	private String location;
	private String result;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public Scores(String date, String location, String result) {
		setDate(date);
		setLocation(location);
		setResult(result);
	}
	
	public String toString() {
		return String.format(
				"%s\n"
				+ "%s\t%s\t%s\t", title,date,location,result);
	}
	
}
