package demoCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoCollection {
 //   private static List<Integer> List=new Vector<Integer>();
  private static List<Integer> list =new ArrayList<Integer>();

    public static void main(String[] args) {
        Random rd=new Random();
        Runnable task=()-> {
            synchronized (list) {
                list.add(rd.nextInt(100));

            }
        };

        ExecutorService pool= Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            pool.submit(task);
        }
        pool.shutdown();
        while (!pool.isTerminated()){} // wait
        System.out.println(list.size());


    }
}
