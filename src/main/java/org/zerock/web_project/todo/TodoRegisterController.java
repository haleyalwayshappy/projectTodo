package org.zerock.web_project.todo;

import jdk.vm.ci.meta.Local;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.zerock.web_project.todo.dto.TodoDTO;
import org.zerock.web_project.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name="todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        log.info("/todo/register GET ......................");
        request.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(request,response);


        //        System.out.println("입력화면을 볼 수 있도록 구성");
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/register.jsp");
//        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{

        TodoDTO todoDTO = TodoDTO.builder()
                .title(request.getParameter("title"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate"),DATEFORMATTER))
                .build();

        log.info("/todo/register POST......");
        log.info(todoDTO);
        try{
            todoService.register(todoDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 브라우저가 호출해야하는 주소
        response.sendRedirect("/todo/list");

    }
}
