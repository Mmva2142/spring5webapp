package guru.spring5webapp.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shifengyuan.
 * Date: 2018/7/2
 * Time: 20:39
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2) {
            @Override
            public void await() throws InterruptedException {
                super.await();
                System.out.println(Thread.currentThread().getName() + " count down is ok");
            }
        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is done");
                countDownLatch.countDown();
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is done");
                countDownLatch.countDown();
            }
        }, "thread2");


        thread1.start();
        thread2.start();

        countDownLatch.await();
    }

}

/*
输出：

thread1 is done
thread2 is done
main count down is ok

CountDownLatch构造函数中的int变量表示需要等待多少个操作的完成。
2表示需要等调用了两次countDown()方法之后，主线程的await()方法才会返回
*/
