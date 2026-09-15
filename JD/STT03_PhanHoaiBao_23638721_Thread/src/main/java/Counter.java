public class Counter {
    private int count=0;

    public synchronized void increase(){
        this.count++;
    }
    public int getCount(){
        return count;
    }
}
