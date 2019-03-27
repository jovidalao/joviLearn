package ThreadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全案例。
 * 主要通过模拟卖电影票方式
 */
public class Demo4{
    public static void main(String[] args) {
        //Thread卖票方法
        SaleTickets4 st = new SaleTickets4();

        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        Thread t3 = new Thread(st);
        t1.start();
        t2.start();
        t3.start();
    }
}
class SaleTickets1 implements Runnable{
    //这是没有加同步锁的情况。
    private int count = 100;
    @Override
    public void run(){
        while (count > 0){
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "卖掉了第" + count);
            count--;
        }
    }
}
class SaleTickets2 implements Runnable{
    //使用同步锁。
    private int count = 100;
    private Object obj = new Object();
    @Override
    public void run(){
        synchronized (obj){
            while (count > 0){
                try {
                    Thread.sleep(140);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖掉了第" + count);
                count--;
            }
        }
    }
}
class SaleTickets3 implements Runnable{
    //同步锁方法
    private int count = 100;

    @Override
    public void run(){
        sale();
    }
    public synchronized void sale(){
        while (count > 0) {
            try {
                Thread.sleep(160);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖掉了第" + count);
            count--;
        }
    }
}
//lock接口方式，主要使用的实现类是reentrannt类
//现存bug，java.lang.IllegalMonitorStateException，不会解决。

class SaleTickets4 implements Runnable{
    Lock l = new ReentrantLock();
    private int count = 1000;
    @Override

    public void run(){
        l.lock();
        while (count > 0){
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + "卖了" + count);

            } catch (InterruptedException e) {
                //e.printStackTrace();
            }count--;
            l.unlock();
        }
    }
}
