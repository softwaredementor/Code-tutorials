package threads;

/**
 * Created by srikanthmannepalle on 8/14/16.
 */
public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println("Inside " + currentThread().getName() + " thread");
        try {
            System.out.println("I'm going to sleep for 3 sec");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Another thread woke me up");
        }
        System.out.println("I am thread = " + currentThread().getName() +" and I woke up after 5 seconds");
    }
}
