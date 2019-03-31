package ThreadDemo;

public class Demo1 {
    public static void ThreadMethod1(){
        Demo3 d3 = new Demo3();
        Thread tr1 = new Thread(d3);
        //比第二种多了这一句
        //含义是设置守护线程。
        tr1.setDaemon(true);
        tr1.start();
        for (int i = 0; i < 30; i++) {
            System.out.println("this is main method" + i);
        }
    }

    public static Thread ThreadMethod2(){
        Demo2 d2 = new Demo2();
        Thread tr = new Thread(d2);
        tr.start();

        for (int i = 0; i < 30; i++) {
            System.out.println("this is mian method" + i);
        }
        return tr;
    }


    public static void main(String[] args) {
        //System.out.println(ThreadMethod2().getName());
        //以下为获取当前的运行的方法的名字的方法。
        //current  当前的
        //System.out.println(Thread.currentThread().getName());
        ThreadMethod1();
        ThreadMethod2();

    }
}
