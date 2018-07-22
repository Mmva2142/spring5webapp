package guru.spring5webapp.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by shifengyuan.
 * Date: 2018/7/2
 * Time: 21:12
 */
@Slf4j
@RunWith(SpringRunner.class)
public class AtomicDemo {

    @Test
    public void atomicReferenceTest() {

        AtomicReference<Integer> count = new AtomicReference<>(0);

        count.compareAndSet(0,2);
        count.compareAndSet(0,1);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        log.info("count:{}", count.get());
    }


}
