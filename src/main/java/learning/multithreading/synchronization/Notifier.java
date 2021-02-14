package learning.multithreading.synchronization;

public class Notifier implements Runnable {

    private Message message;

    public Notifier(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (message) {
                    message.setMessage("Thread " + name + " executed");
//                  message.notify();
                    message.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
