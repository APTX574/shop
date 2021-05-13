package com.example.shop.web;


import com.example.shop.pojo.User;
import com.example.shop.service.UserServie;
import com.example.shop.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
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
            try {
                List<FileItem> fileItems = fileUpload.parseRequest(request);
                for (FileItem item : fileItems) {
                    if (item.isFormField()) {
                        System.out.println("字段名" + item.getFieldName());
                        System.out.println("值" + item.getString("UTF-8"));
                    } else {
                        System.out.println("文件名" + item.getFieldName());
                        item.write(new File("D:\\" + item.getName()));
                    }
                }

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

        System.out.println("我进来了");
        System.out.println(userServie.registerUser(user));
        System.out.println("我进来了");
        return true;
    }

}
