package netDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务器:(ServerSocket)
 * 步骤:
 * 1.创建一个ServerSocket对象,必须绑定一个端口,这个端口必须和客户端连接的端口一致
 * 2.调用server的accept()方法,获取到底哪一个客户端连接的服务器
 * 3.通过刚刚获取到的客户端对象 调用getInputStream()方法
 * 4.通过输入流调用read方法,读取客户端写过来的数据
 * 5.关闭资源
 */
public class ServerDemo {
    public static void text() throws IOException {
        //1.创建一个ServerSocket对象,必须绑定一个端口,这个端口必须和客户端连接的端口一致
        ServerSocket server = new ServerSocket(9909);
        while (true) {
            System.out.println("等待客户端连接并发送文字");
            //获取一下是哪个客户端连接的我
            Socket clients = server.accept();
            String ip = clients.getInetAddress().getHostAddress();
            //打印一些和客户端有关信息
            System.out.println("与" + ip + "建立连接成功");
            //3.获取输入流,实际上是客户端写数据时的输出流
            InputStream is = clients.getInputStream();

            //4.读取数据
            byte[] by = new byte[1024];
            int len = is.read(by);
            System.out.println("客户端说了：" + new String(by, 0, len));
            is.close();
            clients.close();
        }
        //关闭资源，多个资源都需要关闭。
        //server.close();

    }
    public static void file() throws IOException {
        //3.31 实现多线程。
        //未解决BUG：只能接收.jpg格式的文件，解决思路，提前获取文件名。
        ServerSocket server = new ServerSocket(9909);
        while (true) {
            System.out.println("等待客户端来连接并发送文件");
            Socket client = server.accept();
            //在这里会停下，只有接收到客户端的时候才会开启新的一个线程。
            //创建线程对象
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String ip = client.getInetAddress().getHostAddress();
                        System.out.println("与" + ip + "建立连接成功");
                        InputStream is = client.getInputStream();
                        String fileName = "E:\\test\\" + System.currentTimeMillis() + ".jpg";
                        FileOutputStream fos = new FileOutputStream(fileName);
                        //循环写入：
                        byte[] by = new byte[1024];
                        int len = 0;
                        while ((len = is.read(by)) != -1) {
                            fos.write(by, 0, len);
                        }
                        OutputStream otp = client.getOutputStream();
                        otp.write("文件真的上传成功了".getBytes());
                        //System.out.println("文件写入完毕。");
                        fos.close();
                        is.close();
                        client.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();

        }
    }

    public static void main(String[] args) throws IOException {
        file();
        //text();
    }
}
