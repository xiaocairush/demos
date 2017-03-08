package concurrency.semaphore;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by mcai on 3/8/2017.
 */
public class SemaphoreDemo {

    final static int SIZE = 25;

    public static void main(String[] args) throws InterruptedException {
        final Pool<Fat> pool = new Pool<Fat>(Fat.class, SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < SIZE; ++i) {
            exec.execute(new CheckedOutTask<Fat>(pool));
        }
        System.out.println("all CheckedOutTask created");
        ArrayList<Fat> list = new ArrayList<Fat>();
        for(int i= 0 ;i < SIZE; i++) {
            Fat fat = pool.checkOut();
            System.out.println(i + " : main thread checked out ");
            fat.operation();
            list.add(fat);
        }
        Future<?> blocked = exec.submit(new Runnable() {
            public void run() {
                try {
                    pool.checkOut();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);
        System.out.println("checking in objects in " + list);
        for (Fat fat : list) {
            pool.checkIn(fat);
        }
        for (Fat fat : list) {
            pool.checkIn(fat);
        }
        exec.shutdown();
    }

}
