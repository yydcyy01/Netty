package com.yydcyy.nio;

import java.nio.IntBuffer;

/**
 * @author YYDCYY
 * @create 2019-12-01
 *
 * debug 查看四个参数变化, 具体查看对应笔记.
 */
public class BasicBuffer {
    public static void main(String[] args) {
        //举例说明Buffer 的使用 (简单说明)
        //创建一个Buffer, 大小为 5, 即可以存放5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        //如何从buffer读取数据
        //将buffer转换，读写切换
        intBuffer.flip();
        /*
        public final Buffer flip() {
            limit = position; //读数据不能超过5
            position = 0;
            mark = -1;
            return this;
        }
         */
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
