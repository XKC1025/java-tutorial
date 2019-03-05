package com.xkc.learn.IO.cache_stream;

import java.io.*;

/**
 * 字节缓冲输出流:
 *      内置一个字节缓冲数组
 *      使用FileOutputStream, 会给FileOutputStream增加一个缓冲区
 */
public class MyBufferedOutputStream {
    public static void main(String[] args) throws IOException {
        // 创建高效输出流对象
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("/home/xukechen/JavaEE/workspace/java-tutorial/basic/src/main/java/com/xkc/learn/IO/cache_stream/temp.txt", true));

        // 写数据
        outputStream.write(100);

        outputStream.write(new byte[]{101, 102, 103, 104, 105});

        outputStream.write("\n".getBytes());
        outputStream.write("高效缓冲输出流写入的数据".getBytes());

        outputStream.close();
    }
}
