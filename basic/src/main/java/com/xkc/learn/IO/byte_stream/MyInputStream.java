package com.xkc.learn.IO.byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream: 所有字节输入流的抽象类
 *
 * 字节流读取中文, 会导致乱码
 */
public class MyInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("/home/xukechen/JavaEE/workspace/java-tutorial/basic/src/main/java/com/xkc/learn/IO/byte_stream/temp.txt"));

        int read;
//        while ((read = inputStream.read()) != -1) {
//            System.out.println(read);
//        }

        // 读取固定字节数组, 返回读取的字节总数
        byte[] bytes = new byte[3];

        while ((read = inputStream.read(bytes)) != -1) {
            for (int i = 0; i < read; i++) {
                // 字节流读取中文, 会导致乱码
                System.out.println((char)bytes[i]);
            }
        }

        inputStream.close();
    }
}
