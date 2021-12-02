package com.example.controller;

import com.example.dao.SinhVienDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("html/text");
        req.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(req.getParameter("id"));
        if (new SinhVienDao().delSinhvien(id)>0 ) {
            resp.sendRedirect(req.getContextPath()+"/load?msg=2");
        } else resp.sendRedirect(req.getContextPath()+"/load?err=2");
    }
}
