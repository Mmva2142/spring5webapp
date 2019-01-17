package guru.spring5webapp.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

// 1-2 并发编程初体验
// 线程安全，用AtomicInteger两种方法实现
@Slf4j
@RunWith(SpringRunner.class)
//@SpringBootTest 该类做测试不需要进行component scan
public class ConCurrentAtomicTest {


    // 方法一：
    @Test
    public void semaphore() throws InterruptedException {

        AtomicInteger count = new AtomicInteger(0);

        final int threadTotal = 200;
        final int clientTotal = 5000;

        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);        // 允许线程的数目

        for (int i = 0; i < clientTotal; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();            // 从信号量中获取一个允许机会
                    count.incrementAndGet();        // ********  加1 *********
                    semaphore.release();            // 释放允许，将占有的信号量归还
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
            });
        }
        exec.shutdown();

        Thread.sleep(3000);
        log.info("最终结果是 count = {}",count.get());
    }

    // 方法二
    @Test
    public void semaphore_countDownLatch() throws InterruptedException {

        AtomicInteger count = new AtomicInteger(0);

        final int threadTotal = 200;
        final int clientTotal = 5000;

        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);        // 允许线程的数目是200
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);  // 等5000次操作

        for (int i = 0; i < clientTotal; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();            // 从信号量中获取一个允许机会
                    count.incrementAndGet();        // ********  加1 *********
                    semaphore.release();            // 释放允许，将占有的信号量归还
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        exec.shutdown();
        log.info("最终结果是 count = {}",count.get());
    }

    // 方法三：用synchronized修饰

}
