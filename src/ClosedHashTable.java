import java.util.*;
public class ClosedHashTable{
    private ArrayList<ClosedHashMap> row = new ArrayList<ClosedHashMap>();
    private int size;
    public ClosedHashTable(int size){
    		this.size = size;
    		for(int i = 0; i<size; i++) {
    			ClosedHashMap newMap = new ClosedHashMap();
            row.add(i, newMap);
    		}
    }

    public void add(String name, long phone){
        int hashValue = hashFunction(phone);
        ClosedHashMap map = row.get(hashValue);
        map.insertToLinkedList(name, phone);
    }

//    public boolean delete(long phone){
//        int hashValue = hashFunction(phone);
//        if(row.get(hashValue) == null){ return false;}
//        ClosedHashMap map = row.get(hashValue);
//        map.deleteFromLinkedList(phone);
//        return true;
//    }

    public void search(long phone){
        int hashValue = hashFunction(phone);
        ClosedHashMap map = row.get(hashValue);
        String print = map.search(phone) == null ? "Not Found" : map.search(phone);
        System.out.println("Search Result: " + print);
    }

    private int hashFunction(long phone){
        return ((int)phone % this.size);
    }

}