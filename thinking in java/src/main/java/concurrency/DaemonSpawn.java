package concurrency;

/**
 * Created by Administrator on 2015/12/22 0022.
 */
public class DaemonSpawn implements Runnable {

    public void run() {
        while (true)
            Thread.yield();
    }
}
