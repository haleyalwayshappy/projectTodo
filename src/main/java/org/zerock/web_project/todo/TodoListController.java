package org.zerock.web_project.todo;

import org.zerock.web_project.todo.dto.TodoDTO;
import org.zerock.web_project.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("/todo/list");

        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();

        request.setAttribute("list",dtoList);

        request.getRequestDispatcher("/WEB-INF/todo/list.jsp")
                .forward(request,response);
    }
    // jsp파일 생성전이라서 sout으로만 확인 가능하게끔 작성 (page : 68p)
    // > 파일 수정 page :81p  리스트 추가

}
