package learning.multithreading.synchronization;

public class Main {
    public static void main(String[] args) {
        Message message = new Message("Hello world");
        Waiter waiter = new Waiter(message, 0);
        new Thread(waiter, "waiter").start();

        Waiter waiter1 = new Waiter(message, 2000);
        new Thread(waiter1, "waiter1").start();

        Notifier notifier = new Notifier(message);
        new Thread(notifier, "notifier").start();
    }
}
