public class ClosedHashMap{
    private LinkedList list;

    public ClosedHashMap(){
        this.list = null;
    }

    public void insertToLinkedList(String name, long phone){
        LinkedList newList = new LinkedList(name, phone);
        if(isListEmpty()){
            this.list = newList;
        } else {
            this.list.insertToLast(newList);
        }
    }
    
    public String search(long phone) {
    		if(isListEmpty()) return null;
    		return this.list.searchphoneNo(phone);
    }

//    public void deleteFromLinkedList(long phone){}

    public boolean isListEmpty(){
        if(this.list == null) return true;
        return false;
    }
}