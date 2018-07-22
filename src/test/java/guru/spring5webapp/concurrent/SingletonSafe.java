package guru.spring5webapp.concurrent;

/**
 * Created by shifengyuan.
 * Date: 2018/7/3
 * Time: 21:54
 */

//饿汉式单例,线程安全
public class SingletonSafe {

    private static SingletonSafe instance = new SingletonSafe();

    private SingletonSafe(){}

    public static SingletonSafe getInstance() {
        return instance;
    }
}
