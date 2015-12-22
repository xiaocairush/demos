package concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2015/12/22 0022.
 */
public class DaemonThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
