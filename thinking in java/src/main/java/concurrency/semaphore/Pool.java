package concurrency.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by mcai on 3/8/2017.
 */
public class Pool<T> {

    private int size;

    private List<T> items = new ArrayList<T>();

    private volatile boolean[] checkedOut;

    private Semaphore available;

    public Pool(Class<T> classObject, int size) {
        this.size = size;
        checkedOut = new boolean[size];
        available = new Semaphore(size, true);
        for(int i = 0; i < size; ++i) {
            try {
                items.add(classObject.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public T checkOut() throws InterruptedException {
        available.acquire();
        return  getItem();
    }

    public void checkIn(T x) throws InterruptedException {
        if(releaseItem(x))
            available.release();
    }

    private synchronized boolean releaseItem(T x) {
        int i = items.indexOf(x);
        if( i == -1) return false;
        if(checkedOut[i]) {
            checkedOut[i] = false;
            return true;
        }
        return false;
    }

    private synchronized T getItem() {
        for(int i= 0 ; i < size; ++i)
            if(!checkedOut[i]) {
                checkedOut[i] = true;
                return items.get(i);
            }
        return null;
    }
}
