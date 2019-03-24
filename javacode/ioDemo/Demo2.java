package ioDemo;

import java.io.*;

public class Demo2 {
    //测试使用一个字节数组作为字节缓冲区
    //与Demo1比较发现，使用缓冲流后拷贝文件的时间大幅度减少，原因是使用缓冲区后将原本
    //一次循环读写一个字节改为一次循环读写1024甚至更多字节。
    public static void example1() throws IOException {
        InputStream in = new FileInputStream(Demo1.docpath + "qqhead.jpeg");
        OutputStream out = new FileOutputStream(Demo1.docpath + "head.jpeg");
        byte[] buff = new byte[1024];
        //这个数组就是作为缓冲区。
        int len = 0;
        //记录读取入缓冲区的字节数。
        long startTime = System.currentTimeMillis();
        while ((len = in.read(buff)) != -1){
            out.write(buff,0,len);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("拷贝文件所用时间是" + (endTime - startTime));
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException{
        example1();
    }
}
