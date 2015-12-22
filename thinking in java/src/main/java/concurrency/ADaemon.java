package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/12/22 0022.
 */
public class ADaemon implements Runnable {

    public void run() {
        try {
            System.out.println("Starting ADmaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("exit via InterruptedException");
        } finally {
            System.out.println("this should always run?");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
//        TimeUnit.MILLISECONDS.sleep(100);
    }
}
