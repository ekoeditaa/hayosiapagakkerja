import org.json.*;
import java.io.*;
public class Main{
	static long start;
	static long time;
	static JSONArray arrayData;

	private final static String SUCCESSFUL_SEARCH = "SUCCESSFUL SEARCH";
	private final static String UNSUCCESSFUL_SEARCH = "UNSUCCESSFUL SEARCH";
	public static void main (String[]args){
		ClosedHashTable closed = new ClosedHashTable(199);
		getFile();

		//Closed Hash Table Populate Data
		for(int i = 0; i < arrayData.length()-1; i++) {
			String name = arrayData.getJSONObject(i).getString("name");
			long phone = arrayData.getJSONObject(i).getLong("telp");
			closed.add(name, phone);
			System.out.println("Adding : " + name + " " + phone);
		}
		
		testSearch(closed, 10);
		testSearch(closed, 20);
		testSearch(closed, 30);
		testSearch(closed, 40);
		testSearch(closed, 50);
		testSearch(closed, 60);
		testSearch(closed, 70);
		testSearch(closed, 80);
		testSearch(closed, 90);
		testSearch(closed, 100);
		testSearch(closed, 110);
		testSearch(closed, 120);
		testSearch(closed, 130);
		testSearch(closed, 140);
		testSearch(closed, 150);
	}

	public static void testSearch(ClosedHashTable closed, int n) {
		//Closed Hash Table successful search
		startTime();
		for(int i = 0; i < arrayData.length()-1; i += (int)(199/n)) {
			long phone = arrayData.getJSONObject(i).getLong("telp");
			closed.search(phone);
		}
		endTime(n, SUCCESSFUL_SEARCH);

		//Closed Hash Table unsuccessful search
		startTime();
		for(int i = 0; i < arrayData.length()-1; i += (int)(199/n)) {
			long phone = arrayData.getJSONObject(i).getLong("telp")+5120;
			closed.search(phone);
		}
		endTime(n, UNSUCCESSFUL_SEARCH);
	}

	public static void getFile() {
		try
		{
			FileReader filereader = new FileReader("test1.json");
			BufferedReader bufferedreader = new BufferedReader(filereader);
			String line = bufferedreader.readLine();
			//While we have read in a valid line
			JSONObject obj = new JSONObject(line);
			arrayData = obj.getJSONArray("data");
		}
		catch(FileNotFoundException filenotfoundexception)
		{
			System.out.println("File not found.");
		}
		catch(IOException ioexception)
		{
			System.out.println("File input error occured!");
			ioexception.printStackTrace();
		}
	}
	public static void startTime() {
		start = System.nanoTime();
	}
	public static void endTime(int n, String SuccessType){
		time = System.nanoTime() - start;
		double loadFactor = n/199.00;
		System.out.printf("%d " + SuccessType +" search, with load factors %.2f, took an average of %,d ns in total of %,d ns%n", n, loadFactor, time/n, time);
	}
}