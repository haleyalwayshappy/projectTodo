package org.zerock.web_project;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="sampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("doget...." + this);
    }
    @Override
    public void destroy(){
        System.out.println("distroy....................");
    }

    @Override
    public void init(ServletConfig config)throws ServletException{
        System.out.println("init(ServletConfig)..................");

    }
}
