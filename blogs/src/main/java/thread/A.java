package thread;

import java.util.Random;

/**
 * Created by Administrator on 2016/3/17 0017.
 */
public class A {

    private int sum;
    private int count;
    private int printNums;

    public A() {
        sum = count = printNums = 0;
    }

    public synchronized void add(int t,int index) {
        try {
            if (count != index) {
                this.wait();
            } else {
                System.out.println("Thread " + index + " has generated number " + t);
                count++;
                sum += t;
                if (count == 5) {
                    System.out.println("The "+(++printNums)+"th print number is "+sum);
                    sum = count = 0;
                }
                this.notifyAll();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
