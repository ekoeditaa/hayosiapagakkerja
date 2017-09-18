
public class OpenHashTable {
	private static int TABLE_SIZE;
	private HashSlot[] slot;
	public int counter = 0;
	
	public OpenHashTable(int size) {
		TABLE_SIZE = size;
		this.slot = new HashSlot[TABLE_SIZE];
		int i = 0;
		
		for(i = 0;i<TABLE_SIZE;i++) {
			this.slot[i] = new HashSlot();
			this.slot[i].setHashValue(i);
		}
	
	}
	
	public void resetCounter() {
		this.counter = 0;
	}
	
	public String searchName(int num) {
		int temp, i;
		temp = hashNum(num);
		for(i = 0;i < TABLE_SIZE; i++, counter++) {
			if(slot[(temp + i)%TABLE_SIZE].getNum() == num) {
				return slot[(temp + i)%TABLE_SIZE].getName();
			}
		}
		return "Not Found";
		
	}
	
	public int hashNum(int num) {
		return num % TABLE_SIZE;
	}
	
	public int insertData(String name, int num) {
		int temp, i;
		temp = hashNum(num);
		
		for(i = 0;i < TABLE_SIZE; i++) {
			int index = (temp + i)%TABLE_SIZE;
			if(this.slot[index].checkEmpty() == true) {
				this.slot[index].setOpenHashMap(name, num);
				return 0;
			}
		}
		return -1;
	}
	
	
	
}
