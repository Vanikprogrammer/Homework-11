package librury;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Created by 1 on 12.09.2017.
 */
public class Librury {
    private Door door = new Door();
    private Random r = new Random();
    private Semaphore semaphore;
    private int peopleCount;
    private int maxAmount;
    private int count = 0;

    private void initialize(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество людей, желющих почитать");
        peopleCount = sc.nextInt();
        System.out.println("Напишите максимальное количество людей, которые могут одновременно находиться в библиотеке");
        maxAmount = sc.nextInt();
        boolean x = true;
            while (x) {
                if (peopleCount < 0 || maxAmount < 0) {
                    System.out.println("Вы ввели неверное число + \n Попробуйте снова");
                }
                else {
                    semaphore = new Semaphore(maxAmount);
                    x = false;}
            }
    }

    public void start(){
        initialize();
        for(int i = 1; i < peopleCount + 1; i++){
            final int x = i;
            new Thread(() -> {
                System.out.println(x + " - й человек подошел ко входу в библиотеку");
                if(count > maxAmount){
                    System.out.println(x + " - й человек ждет входа в библиотеку");
                }
                door.doorOutside(x);
                try {
                    semaphore.acquire();
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(x + " - й человек зашел в библиотеку и приступил к чтению книги");
                try {
                    Thread.sleep(r.nextInt(4) + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                door.doorInside(x);
                semaphore.release();
                System.out.println(x + " - й человек вышел из бибилиотеки");

            }).start();
        }
    }


}
