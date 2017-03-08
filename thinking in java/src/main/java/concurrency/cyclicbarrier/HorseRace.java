package concurrency.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by mcai on 3/8/2017.
 */
public class HorseRace {

    private final int FINISH_LINE = 75;

    private List<Horse> horses = new ArrayList<Horse>();

    private ExecutorService exec = Executors.newCachedThreadPool();

    private CyclicBarrier barrier;

    public HorseRace(int n, final  int pause) {
        barrier = new CyclicBarrier(n, new Runnable() {

            public void run() {
                StringBuilder s = new StringBuilder();
                for(int i = 0; i < FINISH_LINE; ++i)
                    s.append("=");
                System.out.println(s);
                for (Horse horse : horses) {
                    System.out.println(horse.tracks());
                }
                for (Horse horse : horses) {
                    if(horse.getStrides() > FINISH_LINE) {
                        System.out.println(horse + "won");
                        exec.shutdown();
                        return;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.out.println("barrier-action sleep interrupted");
                }
            }
        });

        for(int i = 0; i < n ; ++i) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int n = 7, pause = 200;
        new HorseRace(n, pause);
    }
}
