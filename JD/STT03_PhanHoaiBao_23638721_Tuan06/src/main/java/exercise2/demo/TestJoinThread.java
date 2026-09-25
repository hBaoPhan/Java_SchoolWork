package exercise2.demo;

import exercise2.thread.YourTask;

public class TestJoinThread {
    public static void main(String[] args) throws Exception {
        new Thread(new YourTask()).start();
    }
}