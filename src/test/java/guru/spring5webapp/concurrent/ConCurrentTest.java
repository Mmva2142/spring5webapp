package guru.spring5webapp.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

// 1-2 并发编程初体验
// 非线程安全的例子，输出少于5000
@Slf4j
@RunWith(SpringRunner.class)
public class ConCurrentTest {

    private static long count = 0;  // 加volatile不好使

    @Test
    public void semaphore() throws InterruptedException {

        final int threadTotal = 200;    // 如果换成1，则输出是5000正常的
        final int clientTotal = 5000;

        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal); // 允许线程的数目

        for (int i = 0; i < clientTotal; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();    // 从信号量中获取一个允许机会
                    count++;
                    semaphore.release();    // 释放允许，将占有的信号量归还
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
        Thread.sleep(3000);

        log.info("count:{}", count);
    }

    // 线程安全，输出=5000
    @Test
    public void semaphore_safe() throws InterruptedException {
        final int threadTotal = 200;
        final int clientTotal = 5000;

        ExecutorService exec = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);        // 允许线程的数目

        for (int i = 0; i < clientTotal; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();            // 从信号量中获取一个允许机会
                    add();
                    semaphore.release();            // 释放允许，将占有的信号量归还
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
        Thread.sleep(3000);

        log.info("count:{}", count);
    }

    private static synchronized void add() {
        count++;
    }

}
