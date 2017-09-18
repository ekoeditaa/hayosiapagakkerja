public class ClosedHashMap{
	private LinkedList list;
	public int counter;

	public ClosedHashMap(){
		this.list = null;
		this.counter = 0;
	}

	public void insertToLinkedList(String name, long phone){
		LinkedList newList = new LinkedList(name, phone);
		if(isListEmpty()){
			this.list = newList;
		} else {
			this.list.insertToLast(newList);
		}
	}

	public String searchphoneNo(long phoneNo){
		if(isListEmpty()) return null;
		else {
			LinkedList list;
			list = this.list;
			do{
				this.counter++;
				if(phoneNo == list.phoneNo) {
					return list.getName();
				}
				list = list.next;
			} while (list != null);
			return null;
		}
	}
	
	public void resetCounter() {
		this.counter = 0;
	}

	//    public void deleteFromLinkedList(long phone){}

	public boolean isListEmpty(){
		if(this.list == null) return true;
		return false;
	}
}