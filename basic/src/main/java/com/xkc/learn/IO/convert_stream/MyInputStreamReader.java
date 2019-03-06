package com.xkc.learn.IO.convert_stream;

import java.io.*;

/**
 * InputStreamReader转换流: 字节通向字符的桥梁
 */
public class MyInputStreamReader {
    public static void main(String[] args) throws IOException {
        // 通过转换流读取指定编码的文件 -> 变成Unicode
        // 读取字节, 变成字符  所以称为转换流
        InputStreamReader reader = new InputStreamReader(new FileInputStream("basic/src/main/java/com/xkc/learn/IO/convert_stream/GBK.txt"), "GBK");

        int len = 0;

        while ((len = reader.read()) != -1) {
            System.out.println((char)len);
        }

        reader.close();
    }
}
