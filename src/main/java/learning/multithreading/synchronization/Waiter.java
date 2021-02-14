package learning.multithreading.synchronization;

public class Waiter implements Runnable {
    private Message message;
    private long sleepTime;

    public Waiter(Message message, long sleepTime) {
        this.message = message;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(sleepTime);
            synchronized (message) {
                System.out.println("Thread " + name + " if waiting for notify");
                message.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + name + " receives notify");
        System.out.println("Thread " + name + ", message: " + message.getMessage());
    }
}