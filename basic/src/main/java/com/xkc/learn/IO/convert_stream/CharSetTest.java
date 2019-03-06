package com.xkc.learn.IO.convert_stream;

import java.io.FileReader;
import java.io.IOException;

public class CharSetTest {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("basic/src/main/java/com/xkc/learn/IO/convert_stream/GBK.txt");

        int len = 0;

        /**
         * 用IDEA默认的UTF-8编码读取GBK编码的文件, 会导致乱码
         */
        while ((len = fileReader.read()) != -1) {
            System.out.println((char)len);
        }
    }
}
