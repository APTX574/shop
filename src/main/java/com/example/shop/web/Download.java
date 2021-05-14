package com.example.shop.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "Download", value = "/Download")
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void down(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = request.getParameter("fileName");
        ServletContext servletContext = request.getServletContext();
        String filePath = "/file/" + fileName;
        response.setContentType(servletContext.getMimeType(filePath));

        InputStream resourceStream = servletContext.getResourceAsStream(fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[102400];
        int len;
        while ((len = resourceStream.read(buff)) != -1) {
            outputStream.write(buff,0,len);
        }


    }
}
