package org.zerock.dao;

import java.sql.SQLOutput;
import java.util.List;
import lombok.Cleanup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.web_project.todo.dao.ConnectionUtil;
import org.zerock.web_project.todo.dao.TodoDAO;
import org.zerock.web_project.todo.domain.TodoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
        todoDAO =new TodoDAO();
    }

    @Test
    public void testTime() throws Exception{
        System.out.println(todoDAO.getTime());
    }


    @Test
    public void testInsert() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .title("Sample title...")
                .dueDate(LocalDate.of(2022,12,31))
                .build();

        todoDAO.insert(todoVO);

    }

    @Test
    public void testList() throws Exception{
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(vo-> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception{
        Long tno =2L;

        TodoVO vo = todoDAO.selectOne(tno);
        System.out.println("testSelectOne"+vo);
    }

    @Test
    public void testUpdateOne() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("sampleTiTle...")
                .dueDate(LocalDate.of(2022,12,31))
                .finished(true)
                .build();
        todoDAO.updateOne(todoVO);
    }
}
