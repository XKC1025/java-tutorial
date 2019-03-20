package com.xkc.learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * BeanUtils工具
 */
@WebServlet("/login")
public class MyServlet7 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 动态获取虚拟目录
        String contextPath = req.getContextPath();

        resp.sendRedirect("/demo6");

        req.setCharacterEncoding("utf-8");

        Map<String, String[]> parameterMap = req.getParameterMap();

        // 创建LoginUser对象
        LoginUser loginUser = new LoginUser();

        // BeanUtils给对象赋值
//        try {
//            BeanUtils.populate(loginUser, parameterMap);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
    }
}
