package com.yydcyy.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author YYDCYY
 * @create 2019-12-01
 * 使用一个Buffer完成文件读取
 * 要求 ByteBuffer(缓冲) 和 FileChannel(通道)， 将 file01.txt 中的数据读入到程序，并显示在控制台屏幕若 02 文件不存在, 则创建
 */
public class NIOFileChannel03 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/yuyang/Downloads/JavaWeb/Test/file01.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/yuyang/Downloads/JavaWeb/Test/file02.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true){

            /*
             .clear() 执行的操作
             public final Buffer clear() {
                position = 0;
                limit = capacity;
                mark = -1;
                return this;
            }
             */
            //情况很重要哦,否则循环读到 0, 不会停止啦
            byteBuffer.clear();
            int read = fileChannel01.read(byteBuffer); // 读到
            System.out.println("read = " + read);
            if (read == -1){ //表示读完
                break;
            }

            //将buffer 中的数据写入到 fileChannel02 -- file02.txt
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }

        //关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
