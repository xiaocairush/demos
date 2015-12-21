package concurrency;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2015/12/21 0021.
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
