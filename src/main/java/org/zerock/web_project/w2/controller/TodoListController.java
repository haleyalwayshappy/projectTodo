package org.zerock.web_project.w2.controller;


import lombok.extern.log4j.Log4j2;
import org.zerock.web_project.w2.dto.TodoDTO;
import org.zerock.web_project.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="todoListController", value="/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        log.info("todo list...............................");

        try{
            List<TodoDTO> dtoList = todoService.listAll();
            request.setAttribute("dtoList",dtoList);
            request.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(request,response);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error");
        }
    }
}
