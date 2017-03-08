package concurrency.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by mcai on 3/8/2017.
 */
public class WaitingTask implements Runnable {

    private static int counter = 0;

    private final int id = counter++;

    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await();
            System.out.println("latch barrier passed for " + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("%1$-3d ", id);
    }

}
