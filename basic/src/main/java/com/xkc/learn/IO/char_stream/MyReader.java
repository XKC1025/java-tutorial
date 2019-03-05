package com.xkc.learn.IO.char_stream;

import java.io.*;

/**
 * 字节流读取中文, 会导致乱码, 用字符流解决
 */
public class MyReader {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader(new File("/home/xukechen/JavaEE/workspace/java-tutorial/basic/src/main/java/com/xkc/learn/IO/byte_stream/temp.txt"));

        // 每次读取一个字符, 在内存中是Unicode字符集, 转成char类型不会导致乱码
        int read;
//        while ((read = reader.read()) != -1) {
//            System.out.println((char)read);
//        }

        // 每次读取一个字符数组
        char[] chars = new char[3];
        while ((read = reader.read(chars)) != -1) {
            for (int i = 0; i < read; i++) {
                System.out.println(chars[i]);
            }

            // 字符数组转换成字符串
            System.out.println(new String(chars));

            System.out.println("===========");
        }

        reader.close();
    }
}
