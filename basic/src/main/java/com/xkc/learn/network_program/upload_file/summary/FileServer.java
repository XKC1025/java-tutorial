package com.xkc.learn.network_program.upload_file.summary;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) throws IOException {
        // 服务器ServerSocket
        ServerSocket serverSocket = new ServerSocket(8888);

        // 服务器死循环
        while (true) {
            // 获得Socket对象
            Socket accept = serverSocket.accept();

            // accept()会阻塞, 在这开启多线程, 可以接受多个客户端的请求
            new Thread(() -> {
                // 获得网络输入流
                InputStream inputStream;
                FileOutputStream fileOutputStream = null;
                try {
                    inputStream = accept.getInputStream();

                    // 文件命名规则
                    String fileName = System.currentTimeMillis() + "";

                    // 创建本地输出流
                    fileOutputStream = new FileOutputStream("/home/xukechen/Downloads/spring" + fileName +".pdf");

                    System.out.println("开始写入文件");

                    // 写入文件
                    // read()方法会一直读取客户端发来的信息, 读不到会阻塞
                    int len = 0;
                    byte[] bytes = new byte[1024];
                    while ((len = inputStream.read(bytes)) != -1) {
                        fileOutputStream.write(bytes, 0, len);
                    }

                    System.out.println("写入文件完毕");

                    // 回写消息
                    OutputStream outputStream = accept.getOutputStream();

                    outputStream.write("上传成功".getBytes());

                    // 关闭输出流, 标志信息发送完毕, 客户端read()方法就不会阻塞
                    accept.shutdownOutput();

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        serverSocket.close();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();

        }


    }
}
