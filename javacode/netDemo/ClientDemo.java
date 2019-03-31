package netDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {
    public static void text() throws IOException {
        //已知问题：连续多次发送信息会失败。
        /*创建一个客户端对象
         * 这个构造方法干了很多事情:
         * a.自动去连接服务器
         * b.自动进行三次握手,建立连接
         * c.自动为连接中创建两个流
         */
        while (true) {
            Socket client = new Socket("127.0.0.1",9909);
            Scanner sc = new Scanner(System.in);
            System.out.println("输入要发送的数据");
            String msg = sc.nextLine();
            client.getOutputStream().write(msg.getBytes());
            System.out.println("给服务器端发送数据成功");
            client.close();
        }
        //最后不要忘记了关闭资源
    }
    public static void file() throws IOException{
        //主要是在服务器端做多次循环接收
        Socket client = new Socket("127.0.0.1",9909);
        OutputStream ops = client.getOutputStream();
        String fileName = "C:\\Users\\10050\\Pictures\\wechathead.jpg";
        FileInputStream fis = new FileInputStream(fileName);
        //循环读取
        byte[] by = new byte[1024];
        int len = 0;
        while ((len = fis.read(by)) != -1) {
            ops.write(by, 0, len);
        }
        client.shutdownOutput();//及时关闭文件输出流，让服务端的输入流及时关闭。
        System.out.println("已经成功发送文件");
        InputStream is = client.getInputStream();
        byte[] byt = new byte[1024];
        int len1 = is.read(byt);
        System.out.println("服务器端说"+new String(byt,0,len1));
        ops.close();
        fis.close();
        client.close();
    }
    public static void main(String[] args) throws IOException {
        file();
        //text();
    }
}
