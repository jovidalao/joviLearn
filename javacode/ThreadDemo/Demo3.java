package ThreadDemo;

/**
 * 这是开启多线程的方法1的实现类
 * 通过继承父类Thread，耦合度高。
 */
public class Demo3 extends Thread{

    @Override
    public void run(){
        for(int i = 0;i < 30; i++){
            System.out.println("线程任务中的"+i);
        }
    }

}
