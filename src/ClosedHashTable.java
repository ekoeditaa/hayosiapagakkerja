import java.util.*;
public class ClosedHashTable{
	private ArrayList<ClosedHashMap> row = new ArrayList<ClosedHashMap>();
	private int size;
	public int counter = 0;

	public ClosedHashTable(int size){
		this.size = size;
		for(int i = 0; i<size; i++) {
			ClosedHashMap newMap = new ClosedHashMap();
			row.add(i, newMap);
		}
	}

	public void resetCounter() {
		for(int i = 0; i<size; i++) {
			ClosedHashMap newMap = new ClosedHashMap();
			newMap.counter = 0;
		}
	}
	public void add(String name, long phone){
		int hashValue = hashFunction(phone);
		ClosedHashMap map = row.get(hashValue);
		map.insertToLinkedList(name, phone);
	}

	public int getCounter() {
		for(int i = 0; i<size; i++) {
			ClosedHashMap newMap = this.row.get(i);
			this.counter += newMap.counter;
		}
		return this.counter;
	}

	public void search(long phone){
		int hashValue = hashFunction(phone);
		ClosedHashMap map = row.get(hashValue);
		String print = map.searchphoneNo(phone) == null ? "Not Found" : map.searchphoneNo(phone);
//		System.out.println("Search Result: " + print);
	}

	private int hashFunction(long phone){
		return ((int)phone % this.size);
	}

}