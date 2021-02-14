package learning.multithreading;

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("first");
        MyThread t2 = new MyThread("second");
        t1.start();
        t2.start();
    }
}
