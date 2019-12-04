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
 * 需求 : ByteBuffer(缓冲) 和 FileChannel(通道)， 将 file01.txt 中的数据读入到程序，并显示在控制台屏幕
 *
 * 假定文件已经存在
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws IOException {
        //创建文件的输入流
        File file = new File("/Users/yuyang/Downloads/JavaWeb/Test/file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        //通过fileInputStream 获取对应的FileChannel -> 实际类型  FileChannelImpl
        FileChannel fileChannel = fileInputStream.getChannel();

        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        //将通道的数据读入到Buffer
        fileChannel.read(byteBuffer);

        //将byteBuffer 的 字节数据 转成String
        System.out.println(new String(byteBuffer.array()));

        //关闭流
        fileInputStream.close();
    }
}
