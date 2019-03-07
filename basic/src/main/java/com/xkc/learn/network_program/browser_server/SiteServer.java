package com.xkc.learn.network_program.browser_server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 浏览器请求 http://127.0.0.1:8888/
 * 会出现请求信息
 */
public class SiteServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        // 接收客户端的Socket请求
        Socket accept = serverSocket.accept();

        // 获取网络输入流
        InputStream inputStream = accept.getInputStream();

        int len;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

    }
}
