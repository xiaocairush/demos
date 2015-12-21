package concurrency;

/**
 * Created by Administrator on 2015/12/21 0021.
 */
public class MoreBasicThreads {

    public static void main(String[] args) {
        for(int i = 0 ;i < 5;i ++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }

}
