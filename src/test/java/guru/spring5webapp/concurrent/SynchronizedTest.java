package guru.spring5webapp.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shifengyuan.
 * Date: 2018/7/2
 * Time: 21:29
 */

@Slf4j
@RunWith(SpringRunner.class)
public class SynchronizedTest {

    // 修饰代码块, 作用于：调用该代码块的对象
    private void block() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("block - {}", i);
            }
        }
    }

    // 修饰方法，作用于：调用该方法的对象
    private synchronized void method() {
        for (int i = 0; i < 10; i++) {
            log.info("method - {}", i);
        }
    }

    @Test
    public void test() {
        SynchronizedTest st = new SynchronizedTest();
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(st::block);    // 用了ExecutorService线程池，
        exec.execute(st::block);    // 连续调用两次execute等于模拟同时启两个线程

        exec.execute(st::method);
        exec.execute(st::method);
    }

    // 修饰类, 作用于：所有对象
    private void classDecorate(int instanceNum) {
        synchronized (SynchronizedTest.class) {
            for (int i = 0; i < 10; i++) {
                log.info("class({}) - {}",instanceNum, i);
            }
        }
    }

    // 修饰静态方法，作用于：所有对象
    private static synchronized void staticDecorate() {
        for (int i = 0; i < 10; i++) {
            log.info("static method - {}", i);
        }
    }

    @Test
    public void test2() {
        SynchronizedTest st1 = new SynchronizedTest();  // 实例化了两个对象
        SynchronizedTest st2 = new SynchronizedTest();

        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(()->{
            st1.classDecorate(1);
        });
        exec.execute(()->{
            st2.classDecorate(2);
        });

        exec.execute(SynchronizedTest::staticDecorate);
        exec.execute(SynchronizedTest::staticDecorate);
    }

    @Test
    public void testStringSplit(){
        String currentUrl = "http://improxy.icbc.com.cn/dlesite/main?code=xxxxx";

        if(currentUrl.indexOf("improxy") > 0){
            int idx = currentUrl.indexOf("/dlesite");
            currentUrl = currentUrl.substring(0,idx) + "/dlfhrel/"+ currentUrl.substring(idx+1);
            currentUrl = currentUrl.replace("http","https");
        }
        System.out.println(currentUrl);
    }
}
