package librury;

import java.util.concurrent.Semaphore;

/**
 * Created by 1 on 12.09.2017.
 */
public class Door {
    private Semaphore out = new Semaphore(1);
    private Semaphore in = new Semaphore(1);
    private final int TIME_DOOR = 500;

    public void doorOutside(int i){
        System.out.println( i + " - й человек подошел к двери с улицы");
        try {
            out.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println();
        }
        System.out.println( i + " - й человек проходит через дверь внутрь");
        try {
            Thread.sleep(TIME_DOOR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out.release();
        System.out.println( i + " - й человек прошел через дверь внутрь");
    }
    public void doorInside(int i){
        System.out.println( i + " - й человек подошел к двери изнутри");
        try {
            in.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println();
        }
        System.out.println( i + " - й человек проходит через дверь наружу");
        try {
            Thread.sleep(TIME_DOOR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        in.release();
        System.out.println( i + " - й человек прошел через дверь наружу");
    }
}
