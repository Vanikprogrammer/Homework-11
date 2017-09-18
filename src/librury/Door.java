package librury;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 1 on 12.09.2017.
 */
public class Door {
    private ReentrantLock outIn = new ReentrantLock();
    private ReentrantLock inOut = new ReentrantLock();
    private final int TIME_DOOR = 500;

    public void doorOutside(int i){
        System.out.println( i + " - й человек подошел к двери с улицы");
        outIn.lock();
        System.out.println( i + " - й человек проходит через дверь внутрь");
        try {
            Thread.sleep(TIME_DOOR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( i + " - й человек прошел через дверь внутрь");
        outIn.unlock();

    }
    public void doorInside(int i){
        System.out.println( i + " - й человек подошел к двери изнутри");
        inOut.lock();
        System.out.println( i + " - й человек проходит через дверь наружу");
        try {
            Thread.sleep(TIME_DOOR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( i + " - й человек прошел через дверь наружу");
        inOut.unlock();

    }
}
