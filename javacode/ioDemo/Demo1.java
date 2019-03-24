package ioDemo;

import java.io.*;

/**基本流程：
 * 1.创建流对象
 * 2.读/写数据
 * 3.关闭流
 */
public class Demo1{
    static String docpath = "/Users/jovidalao/Documents/javaio/";

    public void outs() throws IOException {
        System.out.println("第一个项目，主要测试IO流");
        //Output输出流
        FileOutputStream fos = new FileOutputStream("hello.txt",true);
        //后面的true是代表续写，默认不写为false
        fos.write("hello".getBytes());
        fos.close();
    }

    public static void inputs1() throws IOException{
        //Input输入流，普通方式
        FileInputStream fis1 = new FileInputStream("hello.txt");
        int b = 0;
        while((b = fis1.read()) != -1){
            System.out.print((char)b);
        }
        fis1.close();
    }

    public static void inputs2() throws IOException{
        //Input输入流,标准循环。
        FileInputStream fis2 = new FileInputStream("hello.txt");
        byte[] bt = new byte[4];
        int len = 0;
        while((len = fis2.read(bt)) != -1){ //注意括号
            System.out.print(new String(bt,0,len));
        }
        fis2.close();
    }
    public static void example03() throws IOException{
        InputStream in = new FileInputStream(docpath + "qqhead.jpeg");
        OutputStream out = new FileOutputStream(docpath + "head.jpeg");
        int len = 0;
        long startTime = System.currentTimeMillis();
        while((len = in.read()) != -1){
            out.write(len);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("拷贝图片所消耗的时间是" + (endTime - startTime));
    }
    public static void fileFoundTest() throws IOException{
        File newone = new File(docpath + "233.jpeg");
        boolean hasCreat = newone.createNewFile();
        System.out.println("Done");
        System.out.println(hasCreat);

    }

    public static void main(String[] args) throws IOException {
//        inputs1();
//        inputs2();
        example03();
//        fileFoundTest();
    }
}