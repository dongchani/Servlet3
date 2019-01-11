package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@MultipartConfig
@WebServlet("/uploadServlet")
public class Servlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        /*上传的文件或表格数据。*/
        Part part = req.getPart("file");
        req.getServletPath();
        /*获取文件的真实路径*/
        String uploadDirectory = req.getServletContext().getRealPath("/upload");
        File newFile = new File(uploadDirectory);
        /*新文件如果不存在*/
        if(!newFile.exists()){
            newFile.mkdirs();
        }
        /**/
            part.write(uploadDirectory+ "/" +part.getSubmittedFileName());/*获取提交的图片的文件名*/
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request, response);
    }
}
