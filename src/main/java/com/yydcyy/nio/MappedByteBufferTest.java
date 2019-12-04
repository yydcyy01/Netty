package com.yydcyy.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author YYDCYY
 * @create 2019-12-02
 * NIO 还提供了 MappedByteBuffer， 可以让文件直接在内存（堆外的内存）中进行修改， 而如何同步到文件由NIO 来完成
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/yuyang/Downloads/JavaWeb/Test/file01.txt", "rw");
        //获取对应的通道
        FileChannel channel = randomAccessFile.getChannel();

        /**
         * 参数1: FileChannel.MapMode.READ_WRITE 使用的读写模式
         * 参数2： 0 ： 可以直接修改的起始位置
         * 参数3:  5: 是映射到内存的大小(不是索引位置) ,即将 1.txt 的多少个字节映射到内存
         * 可以直接修改的范围就是 0-5
         * 实际类型 DirectByteBuffer
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(1, (byte) '9');
        mappedByteBuffer.put(2, (byte) 'Y');//IndexOutOfBoundsException
//Exception in thread "main" java.lang.IndexOutOfBoundsException  若 index 大于内容, 报错: 角标越界错误.
        randomAccessFile.close();
        System.out.println("修改成功~~");



    }
}