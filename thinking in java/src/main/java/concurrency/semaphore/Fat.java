package concurrency.semaphore;

/**
 * Created by mcai on 3/8/2017.
 */
public class Fat {

    private volatile double d;

    private static int counter = 0;

    private final int id = counter++;

    public Fat() {
        for(int i = 0; i < 10000; i++) {
            d += (Math.PI + Math.E)/ (double) i;
        }
    }

    public void operation() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "checked out" + id + " ";
    }
}