package concurrency.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by mcai on 3/8/2017.
 */
public class Horse implements Runnable {

    private static int counter = 0;

    private final int id = counter++;

    private int strides = 0;

    private static Random random = new Random(47);

    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier b) {
        barrier = b;
    }

    public synchronized int getStrides() {
        return strides;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += random.nextInt(3);
                }
                barrier.await();
            }
        } catch (InterruptedException e) {

        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                ", strides=" + strides +
                '}';
    }

    public  String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i= 0; i < getStrides(); ++i) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}
