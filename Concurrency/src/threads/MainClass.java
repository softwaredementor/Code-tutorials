package threads;

import runnable.RunnableThread;

/**
 * Created by srikanthmannepalle on 8/14/16.
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("Inside MAIN thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("**Another thread**");
        anotherThread.start();

//        anotherThread.setName("**Another thread**");
//        anotherThread.run();
        System.out.println("Current time = " + System.currentTimeMillis());
        new Thread() {
            public void run() {
                System.out.println("Inside anonymous method");
            }
        }.start();
        Thread runnableThread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Inside anonymous overriden runnable");
            }
        });
        runnableThread1.start();
        Thread runnableThread2 = new Thread(new RunnableThread());
        runnableThread2.start();

        Thread runnableThread3 = new Thread((new RunnableThread(){
            @Override
            public void run() {
                System.out.println("Inside overridden runnable thread");
                System.out.println("Calling another thread to join");
                try {
                    anotherThread.join(2000);
                    System.out.println("Current time = " + System.currentTimeMillis());
                    System.out.println("Another thread either joined early or my time out was over !");
                } catch (InterruptedException e) {
                    System.out.println("some one interrupted another thread called from runnable thhread");
                }
            }
        })
        );
        runnableThread3.start();
        System.out.println("Inside main thread second time");
    }
}