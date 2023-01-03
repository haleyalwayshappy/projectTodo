package org.zerock.web_project.todo;

import org.zerock.web_project.todo.dto.TodoDTO;
import org.zerock.web_project.todo.service.TodoService2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("/todo/read");
        // /todo/read?tno=123
        Long tno  =Long.parseLong(request.getParameter("tno"));
        TodoDTO dto = TodoService2.INSTANCE.get(tno);

        request.setAttribute("dto",dto);

        request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request,response);
//    page : 89p
    }
}
