package ioDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo3 {
    public static void main(String[] args) throws IOException{
        inputsr();
    }
    //InputStreamReader and OutStreamWriter
    public static void inputsr() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("hello.txt"),"UTF-8");
        char[] bt = new char[1024];
        int len = 0;
        while((len = isr.read(bt)) != -1){
            System.out.println();
        }
        int ch = isr.read();
        System.out.println((char)ch);
        isr.close();

    }

}
