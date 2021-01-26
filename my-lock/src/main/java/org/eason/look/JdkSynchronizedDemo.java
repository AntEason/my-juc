package org.eason.look;

public class JdkSynchronizedDemo {
    private static Object object=new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (object){
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread() + "args = " + i);
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.setName("t1");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (object) {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread() + "args = " + i);
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.setName("t2");
        thread2.start();
    }
}
