package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2015/12/21 0021.
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i =0 ;i < 5; i++ )
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
