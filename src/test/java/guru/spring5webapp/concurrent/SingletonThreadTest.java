package guru.spring5webapp.concurrent;

/**
 * Created by shifengyuan.
 * Date: 2018/7/3
 * Time: 21:58
 */
public class SingletonThreadTest extends Thread {

    @Override
    public void run() {
        //System.out.println(SingletonSafe.getInstance().hashCode());
        System.out.println(SingletonEnum.getInstance().hashCode());
        //System.out.println(SingletonUnsafe.getInstance().hashCode());
    }

    public static void main(String[] args) {

        SingletonThreadTest[] sts = new SingletonThreadTest[10];
        for (int i = 0; i < sts.length; i++) {
            sts[i] = new SingletonThreadTest();
        }

        for (SingletonThreadTest st : sts) {
            st.start();
        }
    }

}
