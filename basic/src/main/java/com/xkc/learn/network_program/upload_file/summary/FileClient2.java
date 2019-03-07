package com.xkc.learn.network_program.upload_file.summary;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileClient2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 创建本地输入流
        FileInputStream fileInputStream = new FileInputStream("/home/xukechen/Downloads/spring5.pdf");

        // 创建Socket对象
        Socket socket = new Socket("127.0.0.1", 8888);

        // 创建网络字节输出流
        OutputStream outputStream = socket.getOutputStream();

        Thread.sleep(5000);

        System.out.println("开始发送文件");

        // 发送数据
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        System.out.println("发送文件完毕");

        // 给服务器发送结束标记
        // 终止socket的输出流, 服务器端read()就不会阻塞
        socket.shutdownOutput();

        // 读取回写的数据, 读不到阻塞状态
        InputStream inputStream = socket.getInputStream();
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        System.out.println("111");

        // 释放资源
        socket.close();
        fileInputStream.close();
    }
}
