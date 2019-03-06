package com.xkc.learn.IO.cache_stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyBufferedWriter {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("basic/src/main/java/com/xkc/learn/IO/cache_stream/temp.txt", true));

        writer.write("\n徐");
        writer.write("\n大");
        writer.write("\n王");

        // 新行
        writer.newLine();
        writer.write(97);

        writer.close();
    }
}
