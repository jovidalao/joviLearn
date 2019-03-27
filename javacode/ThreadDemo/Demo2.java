package ThreadDemo;

/**
 * 这是开启多线程的方法1的实现类
 * 通过实现接口，低耦合。
 */
public class Demo2 implements Runnable {

    public void run(){
        for (int i = 0; i < 30; i++) {
        System.out.println("this is Thread method" + i);
        }
    }
}
