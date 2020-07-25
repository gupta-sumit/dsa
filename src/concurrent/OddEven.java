package algo.concurrent;

import java.util.Scanner;

public class OddEven {

    public static void main(String[] args) throws InterruptedException {
        Number number = new Number(1);
        Object lock = new Object();
        Thread t1 = new Thread(new NumberPrinter(lock,3,1,number, 1000));
        Thread t2 = new Thread(new NumberPrinter(lock,3,2,number, 1000));
        Thread t3 = new Thread(new NumberPrinter(lock,3,0,number, 1000));
        t1.start();
        t2.start();
        t3.start();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext() && !"END".equals(scanner.next())) {
            System.out.println("Waiting for input");
        }
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();


//        t1.join();
//        t2.join();
//        t3.join();
        System.out.println("dddd");
    }

    private static class Number {
        private int val;

        public Number(int val) {
            this.val = val;
        }

        public int value() {
            return this.val;
        }

        public void increment() {
            this.val = this.val + 1;
        }
    }

    private static class NumberPrinter implements Runnable {

        private final Object lock;
        private final int k;
        private final Number number;
        private final int maxValue;
        private final int remainder;

        private NumberPrinter(Object lock, int k, int remainder, Number number, int maxValue) {
            this.lock = lock;
            this.k = k;
            this.number = number;
            this.remainder = remainder;
            this.maxValue = maxValue;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    synchronized (lock) {
                        while(number.value() <= maxValue && number.value()%k != remainder) {
                            lock.wait();
                        }
                        if(number.value() > maxValue) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + "  " + number.value());
                        number.increment();
                        Thread.sleep(2000);
                        lock.notifyAll();
                    }
                } catch(InterruptedException e) {
                    System.out.println("Thread interuppted "   + Thread.currentThread().getName());
                    break;
                }

            }

        }
    }


}
