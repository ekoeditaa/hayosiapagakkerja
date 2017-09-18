
public class HashSlot {
	private int hashValue;
	private OpenHashMap hash;
	

	public HashSlot() {
		hash = new OpenHashMap();
	}
	
	public void setHashValue(int num) {
		this.hashValue = num;
	}
	
	public boolean checkEmpty() {
		return this.hash.checkSlot();
	}
	
	public int getNum() {
		return this.hash.getPhoneNum();
	}
	
	public String getName() {
		return this.hash.getName();
	}
	
	public void setOpenHashMap(String name, int num) {
		this.hash.insertKey(name, num);
	}	
}