package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/12/22 0022.
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {

    public DaemonThreadPoolExecutor() {
        super(0,
                Integer.MAX_VALUE, 60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                new DaemonThreadFactory()
        );
    }
}
