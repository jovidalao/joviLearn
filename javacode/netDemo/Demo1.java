package netDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia = InetAddress.getByName("www.bai2du.com");
        System.out.println(ia + "\n" + InetAddress.getLocalHost().toString());

    }
}
