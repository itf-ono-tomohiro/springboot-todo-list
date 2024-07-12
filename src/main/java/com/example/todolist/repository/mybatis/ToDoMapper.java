package com.example.todolist.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.todolist.model.ToDo;

@Mapper
public interface ToDoMapper {
	
	int insert(ToDo toDo);
	
	ToDo select(Long id);
	
	List<ToDo> selectAll();
	
	int update(@Param("toDo") ToDo toDo);
	
	int delete(Long id);

}
