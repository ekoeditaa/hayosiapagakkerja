public class LinkedList{
    private String name;
    public long phoneNo;
    public LinkedList next;

    public LinkedList(String name, long phoneNo){
        this.name = name;
        this.phoneNo = phoneNo;
        this.next = null;
    }
    
    public String getName() { return this.name == null ? "NULL" : this.name; }

    public void insertToLast(LinkedList last){
        LinkedList temp = this;
        while(temp.next != null) {
        		temp = temp.next;
        }
        temp.next = last;
    }
}