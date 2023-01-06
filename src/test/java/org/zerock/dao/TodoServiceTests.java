package org.zerock.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.web_project.todo.domain.TodoVO;
import org.zerock.web_project.todo.dto.TodoDTO;
import org.zerock.web_project.todo.service.TodoService;

import java.time.LocalDate;
@Log4j2
public class TodoServiceTests {
    private TodoService todoService;

    @BeforeEach
    public void ready(){
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister()throws Exception{
                TodoDTO todoDTO = TodoDTO.builder()
                .title("JDBC test Title23")
                .dueDate(LocalDate.now())
                .build();
        log.info("--------------------------"); // 테스트 코드의 log4j2설정 확인
        log.info(todoDTO);

        todoService.register(todoDTO);
    }

}
