package guru.func;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 使用ThreadLocalRandom产生并发随机数
 *
 * Created by shifengyuan.
 * Date: 2018/6/23
 * Time: 22:47
 */
public class TaskLocalRandom implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int num = ThreadLocalRandom.current().nextInt(100);

        for (int i = 0; i < 10; i++) {
            System.out.printf("%s : %s\n", name, num);
        }
    }

    public void testTaskLocalRandom() {
        Thread[] threads = new Thread[3];

        for (int i = 0; i < 3; i++) {
            TaskLocalRandom taskLocalRandom = new TaskLocalRandom();
            threads[i] = new Thread(taskLocalRandom);
            threads[i].start();
        }
    }

    public static void main(String[] args) {
        new TaskLocalRandom().testTaskLocalRandom();
    }
}
