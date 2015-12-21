package concurrency;

/**
 * Created by Administrator on 2015/12/21 0021.
 */
public class LiftOff implements Runnable {

    //default value
    protected int countDown = 10;

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + ( countDown > 0 ? countDown : "LiftOff!") + ").";
    }


    public void run() {
        while (countDown -- > 0) {
            System.out.printf(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}

//todo 1¡¢why the method run() is abstract ?