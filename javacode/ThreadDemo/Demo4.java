package ThreadDemo;

/**
 * 线程安全案例。
 * 主要通过模拟卖电影票方式
 */
public class Demo4{
    public static void main(String[] args) {
        //Thread卖票方法
        SaleTickets3 st = new SaleTickets3();

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
    private int count = 100;
    private Object obj = new Object();
    @Override
    public void run(){
        synchronized (obj) {
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
    private int count = 100;

    @Override
    public void run(){
        while (count > 0){
            sale();
        }

    }
    public synchronized void sale(){
        try {
            Thread.sleep(160);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "卖掉了第" + count);
        count--;
    }
}
