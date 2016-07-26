package thread;

import java.util.Random;

/**
 * Created by Administrator on 2016/3/17 0017.
 */
public class AddNums implements Runnable {

    private A instance;
    private int index;

    public AddNums(A instance, int index) {
        this.instance = instance;
        this.index = index;
    }

    public void run() {
        Random random = new Random(10);
        for(int i=0;i<100;i++) {
            instance.add(random.nextInt(100),index);
        }
    }

    public static void main(String[] args) {
        A a = new A();
        for(int i=0;i < 5;i++) {
            Thread thread = new Thread(new AddNums(a,i));
            thread.start();
        }
    }
}
