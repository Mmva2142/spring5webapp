package guru.spring5webapp.concurrent;

/**
 * @author: yuan
 * Date: 2018/9/10
 * Time: 9:25
 */
public class ThreadLocalExample {
    public static class MyRunnable implements Runnable {

        private ThreadLocal threadLocal = new ThreadLocal();
        private int local = (int) (Math.random() * 100D);

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.out.println("ThreadLocal = " + threadLocal.get());
            System.out.println("local = " + local);
        }
    }

    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
    }
}
