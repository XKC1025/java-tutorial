package com.xkc.learn.IO.char_stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * FileWriter: 文件字符输出流
 */
public class MyWriter {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter(new File("/home/xukechen/JavaEE/workspace/java-tutorial/basic/src/main/java/com/xkc/learn/IO/byte_stream/temp.txt"), true);

        writer.write("徐");
        writer.write("\n");
        writer.write("珂");

        writer.write('A');
        writer.write("珂");

        writer.write(new char[]{'珂', 'J', '\n', 'A', '\n', 'V', 'a', '\\'});
        writer.write(97);


        writer.close();
    }
}
