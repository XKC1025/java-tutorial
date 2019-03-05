package com.xkc.learn.IO.byte_stream;

import java.io.*;

/**
 * OutputStream抽象类是所有字节输出流的抽象类
 * <p>
 * 使用FileOutputStream实现类, 写数据到文件
 */
public class MyOutputStream {
    public static void main(String[] args) throws IOException {
        // 文件字节输出流, 把内存中的数据写入到硬盘
        OutputStream outputStream = new FileOutputStream(new File("/home/xukechen/JavaEE/workspace/java-tutorial/basic/src/main/java/com/xkc/learn/IO/byte_stream/temp.txt"), true);

        // 硬盘上存储的是110001, 97的二进制
        // 记事本打开文件, 会查询编码表, 把二进制转成字符
        // 第一个字节是正数, 查询ASCII表
        // 第一个字节是负数, 加上第二, 第三个字节, 查询UTF-8编码表
        outputStream.write(97);
        outputStream.write(new byte[]{48, 49, 50});
        outputStream.write(new byte[]{98, 99, 100}, 1, 2);
        outputStream.write("中".getBytes());
        outputStream.write("\n".getBytes());
        outputStream.write(97);
        // utf-8三个字节表示一个汉字
        outputStream.write(new byte[]{-28, -72, -83, -27, -101, -67, 97, 98});

        // 资源使用完毕后, 关闭资源
        outputStream.close();
    }
}
