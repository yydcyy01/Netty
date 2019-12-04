package com.yydcyy.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author YYDCYY
 * @create 2019-12-01
 *
 * 需求 : 用 ByteBuffer(缓冲) 和 FileChannel(通道)， 将 "hello, 羽扬" 写入到file01.txt 中
 *
 * 文件不存在就创建
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws IOException {
        String str = "Hello , 羽扬";

        //创建一个输出流->channel
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/yuyang/Downloads/JavaWeb/Test/file01.txt");

        //通过 fileOutputStream 获取 对应的 FileChannel
        //这个 fileChannel 真实 类型是  FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        //创建一个缓冲区 ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将 str 放入 byteBuffer
        byteBuffer.put(str.getBytes());

        //对byteBuffer 进行flip  放在.put / .write 之间
        byteBuffer.flip();

        //将byteBuffer 数据写入到 fileChannel
        fileChannel.write(byteBuffer);

        //关闭流
        fileOutputStream.close();

    }
}
