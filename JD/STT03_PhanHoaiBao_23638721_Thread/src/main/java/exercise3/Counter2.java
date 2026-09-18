package exercise3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter2 {
    private final Lock lock=new ReentrantLock();
    private int count=0;

    public void increase(){
        lock.lock();
        try {
            this.count++;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }
    public int getCount(){
        return count;
    }
}
