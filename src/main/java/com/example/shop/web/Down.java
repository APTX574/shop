package com.example.shop.web;






import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class Down extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        down(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        down(request, response);
    }

    private void down(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = request.getParameter("fileName");
        String filePath = "/file/" + fileName;
        ServletContext servletContext = request.getServletContext();
        InputStream resourceAsStream = servletContext.getResourceAsStream(filePath);
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);


        response.setContentType(servletContext.getMimeType(filePath));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[10240];
        int len;
        while ((len = resourceAsStream.read(buff)) != -1) {
            outputStream.write(buff, 0, len);
        }
    }
}
