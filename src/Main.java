public class Main{
	static long start;
	static long time;
	
    public static void main (String[]args){
        ClosedHashTable closed = new ClosedHashTable(23);
    }
    
    public static void startTime() {
        start = System.nanoTime();
    }
    public static void endTime(int n){
        time = System.nanoTime() - start;
        System.out.printf("Each XXXXX took an average of %,d ns%n", time/n);
    }
}