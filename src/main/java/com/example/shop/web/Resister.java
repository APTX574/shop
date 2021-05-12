package com.example.shop.web;

import com.example.shop.pojo.User;
import com.example.shop.service.UserServie;
import com.example.shop.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Resister extends HttpServlet {
    UserServie userServie = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        dofun(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        dofun(request, response);
    }

    private boolean dofun (HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setSex(request.getParameter("sex"));

        System.out.println("我进来了");
        System.out.println(userServie.registerUser(user));
        System.out.println("我进来了");
        return true;
    }

}
