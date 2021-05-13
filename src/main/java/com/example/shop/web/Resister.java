package com.example.shop.web;


import com.example.shop.pojo.User;
import com.example.shop.service.UserServie;
import com.example.shop.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;


public class Resister extends HttpServlet {
    UserServie userServie = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        dofun(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
            Class<User> clazz = User.class;
            User user = null;
            try {
                user= clazz.getConstructor().newInstance();
                List<FileItem> fileItems = fileUpload.parseRequest(request);
                for (FileItem item : fileItems) {
                    if (item.isFormField()) {
                        Field declaredField = clazz.getDeclaredField(item.getFieldName());
                        declaredField.setAccessible(true);
                        declaredField.set(user, item.getString());
                    } else {
                        System.out.println("文件名" + item.getName());
                        item.write(new File("D:\\" + item.getName()));
                    }
                }
                userServie.registerUser(user);
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("注册成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private boolean dofun (HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setSex(request.getParameter("sex"));
        System.out.println(userServie.registerUser(user));
        return true;
    }

}
