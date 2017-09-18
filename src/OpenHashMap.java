
public class OpenHashMap {
	private String name;
	private int phoneNum;
	private boolean isEmpty;
	
	public OpenHashMap() {
		isEmpty = true;
	}
	
	public void insertKey(String name, int num) {
		this.name = name;
		this.phoneNum = num;
		this.isEmpty = false;
	}
	
	public boolean checkSlot() {
		return isEmpty;
		
	}
	
	public int getPhoneNum() {
		return this.phoneNum;
	}
	
	public String getName() {
		return this.name;
	}
	
}
