package com.xkc.learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发:
 *      调用另外一个Servlet, 服务器内部跳转
 *
 * 地址栏路径不发生变化
 * 只能在服务器内部转发
 * 请求只有一次
 */
@WebServlet("/demo6")
public class MyServlet6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 转发到指定Servlet
        req.getRequestDispatcher("/demo5").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req是域对象, 在多个Servlet之间共享
        // setAttribute() getAttribute() removeAttribute()
        req.setAttribute("object", new Object());

        // 转发到指定Servlet
        req.getRequestDispatcher("/demo5").forward(req, resp);

        req.removeAttribute("object");

        System.out.println(req.getAttribute("object"));

        System.out.println(req.getServletContext());
    }
}
