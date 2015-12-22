package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/12/22 0022.
 */
public class Daemon implements Runnable {

    private Thread[] t = new Thread[10];

    public void run() {
        for(int i =0 ; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started.");
        }

        for (int i = 0 ; i < t.length ; i ++)
            System.out.println("t["+ i +"].isDaemon() = " +
            t[i].isDaemon()+",");
        while (true)
            Thread.yield();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread d  = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = "+ d.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }
}
