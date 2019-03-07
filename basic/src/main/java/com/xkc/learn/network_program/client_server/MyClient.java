package com.xkc.learn.network_program.client_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Socket:
 * TCP通信的客户端, 向服务器发送连接请求, 给服务器发送数据, 读取服务器回写的数据
 * <p>
 * 套接字:
 * 包含了ip和端口号的网络单位
 * <p>
 * 注意:
 * 1.客户端和服务器进行交互, 必须使用Socket提供的网络流, 不能使用自己创建的流
 * 2.
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        // 绑定服务器的IP地址
        Socket socket = new Socket("127.0.0.1", 8888);

        // 获取网络字节输出流对象 getOutputStream()
        OutputStream outputStream = socket.getOutputStream();

        // 给服务器发送数据
        outputStream.write("你好服务器!".getBytes());

        // 终止socket输出流
        socket.shutdownOutput();

        // 获取网络字节输入流 getInputStream()
        InputStream inputStream = socket.getInputStream();

        // 读服务器回写的数据
        int len;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        // 释放资源
        socket.close();

    }
}
