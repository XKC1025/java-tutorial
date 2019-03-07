package com.xkc.learn.IO.cache_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("basic/src/main/java/com/xkc/learn/IO/cache_stream/temp.txt"));

        int len = 0;
        char[] chs = new char[5];

//        while ((len = bufferedReader.read(chs)) != -1) {
//            System.out.println(Arrays.toString(chs));
//        }

        // 每次读取一行
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
