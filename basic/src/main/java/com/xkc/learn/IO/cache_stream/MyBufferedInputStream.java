package com.xkc.learn.IO.cache_stream;

import java.io.*;
import java.util.Arrays;

public class MyBufferedInputStream {
    public static void main(String[] args) throws IOException {
        InputStream iutputStream = new BufferedInputStream(new FileInputStream("basic/src/main/java/com/xkc/learn/IO/cache_stream/temp.txt"), 10);

        // 读数据
        int len;
        byte[] bytes = new byte[7];

        while ((len = iutputStream.read(bytes)) != -1) {
            System.out.println(Arrays.toString(bytes));
        }

        iutputStream.close();
    }
}
