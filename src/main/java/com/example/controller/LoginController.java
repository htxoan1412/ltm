package com.example.controller;

import com.example.dao.SinhVienDao;

import com.example.model.SinhvienModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/checkLogin")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=  req.getParameter("username");
        String pass = req.getParameter("pass");
        SinhvienModel sinhvien = new SinhVienDao().checkLogin(username,pass);
        if (sinhvien!=null) {
            HttpSession session = req.getSession();
            session.setAttribute("userLogin1", sinhvien);
            req.getRequestDispatcher(req.getContextPath() + "/load").forward(req,resp);
        }
        else{

                req.getRequestDispatcher("login.jsp").forward(req, resp);

            }

        }
}
