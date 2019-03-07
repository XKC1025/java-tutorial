package com.xkc.learn.network_program.client_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        // 接收客户端的Socket请求
        Socket accept = serverSocket.accept();

        // 获取网络输入流
        InputStream inputStream = accept.getInputStream();

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        // 获取网络输出流
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("收到, 谢谢!".getBytes());

        serverSocket.close();
    }
}
