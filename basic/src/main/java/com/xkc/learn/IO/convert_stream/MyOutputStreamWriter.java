package com.xkc.learn.IO.convert_stream;

import java.io.*;

/**
 * 写数据到文件, 指定GBK编码
 */
public class MyOutputStreamWriter {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("basic/src/main/java/com/xkc/learn/IO/convert_stream/GBKWrite.txt"), "GBK");

        writer.write("中国");
        writer.write('\n');
        writer.write("徐珂琛");

        writer.close();
    }
}
