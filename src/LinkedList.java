public class LinkedList{
    private String name;
    private long phoneNo;
    private LinkedList next;

    public LinkedList(String name, long phoneNo){
        this.name = name;
        this.phoneNo = phoneNo;
        this.next = null;
    }
    
    public String getName() { return this.name == null ? "NULL" : this.name; }
    
    public String searchphoneNo(long phoneNo){
        LinkedList list;
        list = this;
        do{
            if(phoneNo == list.phoneNo) return list.getName();
            list = list.next;
        } while (list != null);
        return null;
    }

    public void insertToLast(LinkedList last){
        LinkedList temp = this;
        while(temp.next != null) {
        		temp = temp.next;
        }
        temp.next = last;
    }
}