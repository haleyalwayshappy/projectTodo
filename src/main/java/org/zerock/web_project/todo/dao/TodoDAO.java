package org.zerock.web_project.todo.dao;

import lombok.Cleanup;
import org.zerock.web_project.todo.domain.TodoVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    // 시간 얻는 방법은 두가지다 > 기본 try-catch 를 사용한 방법과, @Cleanup 어노테이션을 사용하는 방법!  후자가 좀 더 코드가 간결하다.
    // TODO : 시간 가져오는 방법
    public String getTime() {
        String now = null;
        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement("select now()");
             ResultSet resultSet = preparedStatement.executeQuery();
        ){
            resultSet.next();

            now = resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return now;
    }
    // TODO : 시간 가져오는 방법2
    public String getTime2() throws Exception{
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement =connection.prepareStatement("select now()");

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        String now = resultSet.getNString(1);
        return now;
    }

    // TODO : 인서트 쿼리
    public void insert(TodoVO todoVO) throws Exception {
        String sql = "insert into tbl_todo(title,dueDate,finished) values(?,?,?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement =connection.prepareStatement(sql);

        preparedStatement.setString(1, todoVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(todoVO.getDueDate()));
        preparedStatement.setBoolean(3, todoVO.isFinished());

        preparedStatement.executeUpdate();
    }

    // TODO : 목록 전체 조회
    public List<TodoVO> selectAll()throws Exception{
        String sql = "select * from tbl_todo";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

         List<TodoVO> list = new ArrayList<>();

        while(resultSet.next()){
            TodoVO vo = TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();

            list.add(vo);
        }
    return list ;
    }

// TODO :특정 데이터 조회 (상세보기) 
    public TodoVO selectOne(Long tno)throws Exception{
        String sql = "select * from tbl_todo where tno = ? ";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setLong( 1, tno);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        TodoVO vo= TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                        .finished(resultSet.getBoolean("finished"))
                        .build();
        return vo;

    }

//    TODO : 컬럼 삭제
    public void deleteOne(Long tno) throws Exception{
        String sql = "delete from tbl_todo where tno =?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1,tno);
        preparedStatement.executeUpdate();
    }


//    TODO : 컬럼 수정
    public void updateOne(TodoVO todoVO) throws Exception{
        String sql = "update tbl_todo set title=?, dueDate=? , finished=? where tno =?" ;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,todoVO.getTitle());
        preparedStatement.setDate(2,Date.valueOf(todoVO.getDueDate()));
        preparedStatement.setBoolean(3,todoVO.isFinished());
        preparedStatement.setLong(4,todoVO.getTno());

        preparedStatement.executeUpdate();

    }
}
