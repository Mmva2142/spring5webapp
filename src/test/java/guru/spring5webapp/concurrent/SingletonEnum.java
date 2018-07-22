package guru.spring5webapp.concurrent;

/**
 * Created by shifengyuan.
 * Date: 2018/7/3
 * Time: 22:38
 */

//枚举单例，线程安全，推荐使用

public class SingletonEnum {

    private SingletonEnum() {
    }

    public static SingletonEnum getInstance() {
        return Helper.INSTANCE.getInstance();
    }

    private enum Helper {
        INSTANCE;

        private SingletonEnum singletonEnum;

        // jvm保证该构造方法仅被调用一次
        Helper() {
            singletonEnum = new SingletonEnum();
        }

        public SingletonEnum getInstance() {
            return singletonEnum;
        }
    }

    /*
    * 枚举类型会由JVM在加载的时候，实例化枚举对象，你在枚举类中定义了多少个,就会实例化多少个，(这里就INSTANCE一个)
    * JVM为了保证每一个枚举类元素的唯一实例，是不会允许外部进行new的，
    * 所以会把枚举的构造函数设计成默认private，防止用户生成实例，破坏唯一性
    * */
}
