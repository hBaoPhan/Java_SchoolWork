package exercise1.demo;

import exercise1.thread.ComputationTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ComputationExecutor {
    public static void main(String[] args) throws Exception {
        Callable<Long> call = new ComputationTask("long-last-computaion");
        FutureTask<Long> task = new FutureTask<>(call);
        new Thread(task).start();

        //Waits if necessary for the computation to complete,
        //and then retrieves its result.
        long result = task.get();
        System.out.println("Result:" + result);
    }
}