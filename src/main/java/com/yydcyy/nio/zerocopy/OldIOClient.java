package com.yydcyy.nio.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class OldIOClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 7001);

        //String fileName = "/Users/yuyang/Downloads/JavaWeb/Test/zel-copy.jpg";
        String fileName = "/Users/yuyang/Movies/2001.天使爱美丽/1.mkv";
        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();

        while ((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("发送总字节数： " + total + ", 耗时： " + (System.currentTimeMillis() - startTime));

        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }
}
/**
 发送总字节数： 1991601, 耗时： 4 [ 2m 文件 ]

 发送总字节数： 2753761824, 耗时： 2506   [ 2.7G 文件]
 */