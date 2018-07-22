package guru.spring5webapp.concurrent;

/**
 * Created by shifengyuan.
 * Date: 2018/7/3
 * Time: 22:07
 */

//懒汉式，非线程安全
public class SingletonUnsafe {

    private static SingletonUnsafe instance = null;

    private SingletonUnsafe() {
    }

    public static SingletonUnsafe getInstance() {

        if (instance == null) {
            try {
                //创建实例之前可能会有一些准备性的耗时工作
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new SingletonUnsafe();
        }
        return instance;
    }
}
