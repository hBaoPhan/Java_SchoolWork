public class DemoThread4 {
    public static void main(String[] args) {
        System.out.printf("(%s, %s)%n",Thread.currentThread().getName(),Thread.currentThread().getPriority());// (main, 5)

        Thread thread1=new Thread();
        System.out.printf("(%s, %s)%n",thread1.getName(),thread1.getPriority()); //(Thread-0, 5)

        Thread.currentThread().setPriority(7);
        System.out.printf("(%s, %s)%n",Thread.currentThread().getName(),Thread.currentThread().getPriority());//(main, 7)

        Thread thread2=new Thread();
        System.out.printf("(%s, %s)%n",thread2.getName(),thread2.getPriority());//(Thread-1, 7)

        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);
        System.out.println(Thread.MAX_PRIORITY);
    }

    }

