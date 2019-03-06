package com.xkc.learn.IO.print_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 打印流:
 *      println()方法:
 *              在终端 / 文件原样输出
 *      write()方法:
 *              写到文件就是二进制
 */
public class MyPrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(97);

        PrintStream printStream = new PrintStream(new FileOutputStream("basic/src/main/java/com/xkc/learn/IO/print_stream/print.txt"));

        int i = 97;
        printStream.write(i);
        printStream.println(i);
        printStream.println(i);
        printStream.println(i);

        printStream.close();

        // 默认在终端输出, 可以改变打印流的输出的目的地
        System.setOut(new PrintStream(new FileOutputStream("basic/src/main/java/com/xkc/learn/IO/print_stream/printDesc.txt")));
        System.out.println("改变了目的地");

    }
}
