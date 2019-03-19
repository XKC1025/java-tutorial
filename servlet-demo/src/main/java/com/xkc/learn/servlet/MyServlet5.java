package com.xkc.learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/demo5")
public class MyServlet5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);

        // 获取请求行数据
        System.out.println(req.getMethod());
        // 获取虚拟目录
        System.out.println(req.getContextPath());
        System.out.println(req.getServletPath());
        System.out.println(req.getQueryString());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getProtocol());
        System.out.println(req.getRemoteAddr());

        System.out.println("=============");

        // 请求头
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(req.getHeader(headerNames.nextElement()));
        }

        System.out.println("=============");

        // 请求体


        System.out.println("doGet....");

        getParameter(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getAttribute("object"));

        System.out.println("doPost....");

        // 请求体
        // 封装成流对象  getReader()  getInputStream()
        BufferedReader reader = req.getReader();

        char[] chs = new char[5];
        int len = -1;

        while ((len = reader.read(chs)) != -1) {
            System.out.println(String.valueOf(chs, 0, len));
        }

        getParameter(req, resp);

    }

    private void getParameter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置流的编码
        req.setCharacterEncoding("utf-8");

        // 通用方式获取参数
        // String getParameter(String var1);
        System.out.println(req.getParameter("kk"));
        // Enumeration<String> getParameterNames();
        // String[] getParameterValues(String var1);
        // Map<String, String[]> getParameterMap();

        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> strings = parameterMap.keySet();

        for (String str : strings) {
            String[] strings1 = parameterMap.get(str);

            System.out.println(Arrays.toString(strings1));
        }
    }
}
