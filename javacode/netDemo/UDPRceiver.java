package netDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPRceiver{
    public static void main(String[] args) throws Exception{
        //先创建DatagramSocket对象，必须指定一个端口号
        DatagramSocket ds = new DatagramSocket(9909);
        while (true) {

            //创建DatagramPacket对象
            byte[] ls = new byte[1024];

            DatagramPacket dp = new DatagramPacket(ls, ls.length);
            //储存发送的数据，
            System.out.println("等待发送数据。");
            ds.receive(dp);
            System.out.println("已经成功接受数据");
            //获取发送端的地址(从数据包中)
            InetAddress ita = dp.getAddress();
            System.out.println("发送端是" + ita.getHostAddress());

            //接收真正的数据
            byte[] data = dp.getData();
            int len = dp.getLength();

            String reveiveMsg = new String(data, 0, len);

            System.out.println(reveiveMsg);
        }
        //ds.close();
    }

}
