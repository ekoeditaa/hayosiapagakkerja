import org.json.*;
import java.io.*;
public class Main{
	static long start;
	static long time;
	static JSONArray arrayData;

	private final static String SUCCESSFUL_SEARCH = "SUCCESSFUL SEARCH";
	private final static String UNSUCCESSFUL_SEARCH = "UNSUCCESSFUL SEARCH";
	public static void main (String[]args){
		getFile();
		
//		test1(0.1);
//		test1(0.25);
//		test1(0.5);
//		test1(0.75);
		test1(1);
		test1(1.50);
		test1(1.75);
		test1(2.00);
	}

	public static void test1(double loadFactor) {
		int size = (int)(199/loadFactor);
		ClosedHashTable closed = new ClosedHashTable(size);
		OpenHashTable open = new OpenHashTable(size);
		//Closed and Open Hash Table Populate Data
		for(int i = 0; i < arrayData.length()-1; i++) {
			String name = arrayData.getJSONObject(i).getString("name");
			long phone = arrayData.getJSONObject(i).getLong("telp");
			closed.add(name, phone);
			open.insertData(name, (int)phone);
//			System.out.println("Adding : " + name + " " + phone);
		}
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Closed");
		testSearch(closed, size, 150);
//		System.out.println("---------------------------------------------------------------------------");
//		System.out.println("Open");
//		testSearchOpen(open, size, 150);
	}

	public static void testSearch(ClosedHashTable closed, int size, int search) {
		//Closed Hash Table successful search
		startTime();
		for(int i = 0; i < arrayData.length()-1; i += 1) {
			if(i == search) break;
			long phone = arrayData.getJSONObject(i).getLong("telp");
			closed.search(phone);
		}
		endTime(size, search, SUCCESSFUL_SEARCH);
		System.out.println("Average successful number of key comparisons: "  + closed.getCounter()/150);
		closed.resetCounter();

		//Closed Hash Table unsuccessful search
		startTime();
		for(int i = 0; i < arrayData.length()-1; i += 1) {
			if(i == search) break;
			long phone = arrayData.getJSONObject(i).getLong("telp")+5120;
			closed.search(phone);
		}
		endTime(size, search, UNSUCCESSFUL_SEARCH);
		System.out.println("Average unsuccessful number of key comparisons: "  + closed.getCounter()/150);
		closed.resetCounter();
	}
	
	public static void testSearchOpen(OpenHashTable open, int size, int search) {
		//Open Hash Table successful search
		startTime();
		for(int i = 0; i < arrayData.length()-1; i += 1) {
			if(i == search) break;
			long phone = arrayData.getJSONObject(i).getLong("telp");
			open.searchName((int)phone);
		}
		endTime(size, search, SUCCESSFUL_SEARCH);
		System.out.println("Average successful number of key comparisons: "  + open.counter/150);
		open.resetCounter();
		//Open Hash Table unsuccessful search
		startTime();
		for(int i = 0; i < arrayData.length()-1; i += 1) {
			if(i == search) break;
			long phone = arrayData.getJSONObject(i).getLong("telp")+5120;
			open.searchName((int)phone);
		}
		endTime(size, search, UNSUCCESSFUL_SEARCH);
		System.out.println("Average unsuccessful number of key comparisons: "  + open.counter/150);
		open.resetCounter();
	}

	public static void getFile() {
		try
		{
			FileReader filereader = new FileReader("test1.json");
			BufferedReader bufferedreader = new BufferedReader(filereader);
			String line = bufferedreader.readLine();
			bufferedreader.close();
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
	public static void endTime(int m, int search, String SuccessType){
		time = System.nanoTime() - start;
		System.out.printf("%d searches from %d table size with 199 sample " + SuccessType +" search, with load factors %.2f, took an average of %,d ns in total of %,d ns%n", 
				search, m, 199/(m+0.00), time/search, time);
	}
}
