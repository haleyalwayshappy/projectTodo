package org.zerock.web_project.todo.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.web_project.todo.dao.TodoDAO;
import org.zerock.web_project.todo.domain.TodoVO;
import org.zerock.web_project.todo.dto.TodoDTO;
import org.zerock.web_project.todo.util.MapperUtil;

@Log4j2
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
//        System.out.println("todoVO"+todoVO);
       log.info(todoVO);
        dao.insert(todoVO);
    }
//
//    public void updateRegister (TodoDTO todoDTO) throws Exception{
//        TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);
//        System.out.println("todoVO Update"+todoVO);
//        dao.updateOne(todoVO);
//    }
;
}
