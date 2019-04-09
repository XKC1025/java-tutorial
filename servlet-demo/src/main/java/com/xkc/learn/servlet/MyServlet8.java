package com.xkc.learn.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo8")
public class MyServlet8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 防止中文乱码
        // resp.setCharacterEncoding("utf-8");

        // 告诉浏览器响应的编码, 防止乱码
        resp.setContentType("text/html;charset=utf-8");

//        ServletOutputStream outputStream = resp.getOutputStream();
        PrintWriter writer = resp.getWriter();

        writer.write("Hello, World!你好");
    }
}
