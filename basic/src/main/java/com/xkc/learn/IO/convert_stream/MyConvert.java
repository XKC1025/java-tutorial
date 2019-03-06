package com.xkc.learn.IO.convert_stream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MyConvert {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("basic/src/main/java/com/xkc/learn/IO/convert_stream/GBK.txt"), "GBK");
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("basic/src/main/java/com/xkc/learn/IO/convert_stream/GBK_TO_UTF8.txt"), StandardCharsets.UTF_8);

        int len = 0;

        while ((len = reader.read()) != -1) {
            writer.write(len);
        }

        reader.close();
        writer.close();
    }
}
