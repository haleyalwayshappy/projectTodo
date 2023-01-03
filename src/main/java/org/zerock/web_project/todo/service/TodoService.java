package org.zerock.web_project.todo.service;

import org.modelmapper.ModelMapper;
import org.zerock.web_project.todo.dao.TodoDAO;
import org.zerock.web_project.todo.domain.TodoVO;
import org.zerock.web_project.todo.dto.TodoDTO;
import org.zerock.web_project.todo.util.MapperUtil;

public enum TodoService {
    INSTANCE;
    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService(){
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO)throws Exception{
        TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);
        System.out.println("todoVO"+todoVO);
        dao.insert(todoVO);
    }

}
