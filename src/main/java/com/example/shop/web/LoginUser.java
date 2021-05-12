package com.example.shop.web;

import com.example.shop.pojo.User;
import com.example.shop.service.UserServie;
import com.example.shop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginUser extends HttpServlet {
    private UserServie userServie = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        dofun(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        dofun(request, response);
    }

    private void dofun(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (name!=null&&password!=null) {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            User user1 = userServie.loginUser(user);
            try {
                if (user1 != null) {
                    response.setContentType("text/html;charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");

                    response.getWriter().write("登录成功");
                    return;
                }
                response.sendRedirect("localhost:8080/shop/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
