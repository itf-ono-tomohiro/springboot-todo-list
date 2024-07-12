package com.example.todolist.service;

import java.util.List;

import com.example.todolist.model.ToDo;

public interface ToDoService {
	
	
	ToDo getToDo(Long id);
	
	List<ToDo> getToDos();
	
	ToDo createToDo(ToDo toDo);
	
	int updateToDo(ToDo toDo);
	
	void delete(Long id);

}
