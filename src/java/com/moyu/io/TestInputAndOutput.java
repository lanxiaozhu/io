package com.moyu.io;

import java.io.*;

/**
 * @Auther: wishm
 * @Date: 2019/6/29 23:42
 * @Description: 测试io 字节流读取文件  和 写入
 */
public class TestInputAndOutput {
    public static void main(String[] args) {
        /**
         * 两种写法！根据源码看 是一样的
         */
        //File file = new File("classpath:readme.MD");
        //FileInputStream fileInputStream = new FileInputStream(file);
        try {

            //1、读取文件
            FileInputStream fileInputStream = new FileInputStream("readme.MD");

            //2、写出文件
            FileOutputStream out = new FileOutputStream("test.txt");

            //3、数据暂时存放到 字节数组中
            byte[] bytes = new byte[1024];
            //4、 每次读取的字节长度
            int n = 0;

            try {
                //当io读取不到有效数据时 返回 -1
                while( ( n = fileInputStream.read(bytes) ) != -1 ){
                    out.write(bytes,0,n);// 将读取的内容，写入到输出流当中
                }

                //  i/o操作中缓冲区是要用到的，对于输出流，一般是在缓冲区写满后才输出，如果用flush(),则是缓冲区没有写满时就输出
                //out.flush(); 是不是我用不到 缓冲区，就不需要flush了

                out.close();


                fileInputStream.close();

                System.out.println("over");

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("fileContentReadException"+e);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
