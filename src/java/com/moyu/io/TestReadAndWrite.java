package com.moyu.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther: wishm
 * @Date: 2019/6/30 12:45
 * @Description:测试io 字符流读取文件  和 写入
 */
public class TestReadAndWrite {
    public static void main(String[] args) {
        try {
            //1、读取文件
            FileReader reader = new FileReader("readme.MD");

            try {
                //2、写入文件
                FileWriter writer = new FileWriter("writer.txt");

                //3、数据暂时存放到 字符数组中
                char[] cs = new char[1024];

                int lenth= 0 ;

                while((lenth = reader.read(cs)) != -1){

                    writer.write(cs,0,lenth);
                }


                writer.flush();
                writer.close();
                reader.close();
                System.out.println("over");


            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
