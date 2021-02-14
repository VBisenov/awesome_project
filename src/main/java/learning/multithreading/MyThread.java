package learning.multithreading;

public class MyThread implements Runnable {
    private Thread thread;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Run thread " + name);
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread: " + name + ", " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " interrupted");
            e.printStackTrace();
        }
        System.out.println("Thread " + name + " exiting");
    }

    public void start() {
        System.out.println("Start thread " + name);
        if (thread == null) {
            thread = new Thread(this, name);
            thread.start();
        }
    }
}
