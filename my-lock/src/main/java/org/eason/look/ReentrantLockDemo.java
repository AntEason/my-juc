package org.eason.look;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    //创建重入锁
    public static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            reentrantLock.lock();
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread() + "args = " + i);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }

        });
        thread1.setName("t1");
        thread1.start();
        Thread thread2 = new Thread(() -> {
            reentrantLock.lock();
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread() + "args = " + i);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });
        thread2.setName("t2");
        thread2.start();
    }
}
