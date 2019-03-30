package netDemo;

import java.net.*;
import java.util.Scanner;

public class UDPSender {
    public static void main(String[] args) throws Exception {
        //新建一个收发器
        DatagramSocket ds = new DatagramSocket();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("输入要发送的数据。");
            String msg = sc.nextLine();
            byte[] by = msg.getBytes();
            //新建一个数据包
            DatagramPacket dp = new DatagramPacket(by, by.length, InetAddress.getLocalHost(), 9909);
            //把数据包放入收发器
            ds.send(dp);
            System.out.println("done");
        }
        //ds.close();
    }

}
