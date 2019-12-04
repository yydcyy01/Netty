package com.yydcyy.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author YYDCYY
 * @create 2019-12-01
 *   使用transferFrom 方法拷贝文件
 * 要求 : 使用 FileChannel(通道) 和 方法  transferFrom ，完成文件的拷贝
 * 拷贝一张图片
 */
public class NIOFileChannel04 {
    public static void main(String[] args) throws IOException {
        //创建相关流
        FileInputStream fileInputStream = new FileInputStream("/Users/yuyang/Pictures/zel.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/yuyang/Downloads/JavaWeb/Test/zel-copy.jpg");

        //获取各个流对应的filechannel
        FileChannel sourceCh = fileInputStream.getChannel();
        FileChannel destCh = fileOutputStream.getChannel();

        //使用transferForm完成拷贝
        destCh.transferFrom(sourceCh, 0, sourceCh.size());

        //关闭相关通道和流
        sourceCh.close();
        destCh.close();

        fileInputStream.close();
        fileOutputStream.close();
    }
}
