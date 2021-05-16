package com.example.shop.web;

import com.example.shop.pojo.User;
import com.example.shop.service.UserServie;
import com.example.shop.service.impl.UserServiceImpl;


import javax.servlet.http.*;
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
                    HttpSession session = request.getSession();
                    session.setAttribute("user", name);
                    Cookie cookie = new Cookie("name", user1.getName());
                    cookie.setMaxAge(60*60*24*7);
                    response.addCookie(cookie);
                    response.setStatus(302);


                    response.sendRedirect("http://localhost:8080/shop/download.jsp");
                    return;
                }
                response.sendRedirect("http://localhost:8080/shop/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
