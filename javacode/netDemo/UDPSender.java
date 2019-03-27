package netDemo;

import java.net.*;

public class UDPSender {
    public static void main(String[] args) throws Exception {
        //新建一个收发器
        DatagramSocket ds = new DatagramSocket();
        //新建一个数据包
        byte[] by = "jovidalao".getBytes();
        DatagramPacket dp = new DatagramPacket(by,by.length, InetAddress.getLocalHost(),12345);
        //把数据包放入收发器
        ds.send(dp);
        System.out.println("done");
    }

}
