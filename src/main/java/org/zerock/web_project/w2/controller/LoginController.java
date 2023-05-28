package org.zerock.web_project.w2.controller;


import lombok.extern.java.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        log.info("login get.....");

        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        log.info("login post ........");

        String mid = request.getParameter("mid");
        String mpw = request.getParameter("mpw");

        String str = mid+mpw;

        HttpSession session = request.getSession();
        session.setAttribute ("loginInfo", str);
        response.sendRedirect("/todo/list");

    }
}
