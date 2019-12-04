package com.yydcyy.nio;

import java.nio.ByteBuffer;

/**
 * @author YYDCYY
 * @create 2019-12-01
 * ByteBuffer 支持类型化的put 和 get, put 放入的是什么数据类型，get就应该使用相应的数据类型来取出，否则可能有 BufferUnderflowException 异常。[举例说明]
 */
public class NIOByteBufferPutGet {
    public static void main(String[] args) {
        //创建一个Buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        //类型化方式放入数据
        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('羽');
        buffer.putShort((short) 4);

        //取出
        buffer.flip();

        System.out.println();

        // 取出顺序不同, 会报错 thread "main" java.nio.BufferUnderflowException
        System.out.println(buffer.getInt());
        /*System.out.println(buffer.getInt());
        System.out.println(buffer.getInt());
        System.out.println(buffer.getInt());
        System.out.println(buffer.getInt());*/

        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());

    }
}
