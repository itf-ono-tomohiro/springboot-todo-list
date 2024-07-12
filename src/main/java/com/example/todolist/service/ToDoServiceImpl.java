package com.example.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.exception.ToDoNotFoundException;
import com.example.todolist.model.ToDo;
import com.example.todolist.repository.mybatis.ToDoMapper;

@Service
public class ToDoServiceImpl implements ToDoService {
	
	@Autowired
	private ToDoMapper mapper;
	
	//todolistを全件取得
	@Override
	public List<ToDo> getToDos(){
		return mapper.selectAll();
	}
	
	// todolistを一件取得
	public ToDo getToDo(Long id){
		ToDo toDo = mapper.select(id);
		if(toDo == null) {
			throw new ToDoNotFoundException(id);
		}
		return toDo;
	}
	
	// todolistに一件追加
	@Override
	public ToDo createToDo(ToDo toDo) {
		mapper.insert(toDo);
		return toDo;
	};
	
	// todolistを一件更新
	@Override
	public int updateToDo(ToDo toDo) {
		return mapper.update(toDo);
	}
	
	// todolistを一件削除
	public void delete(Long id) {
		ToDo toDo = mapper.select(id);
		if(toDo == null) {
			throw new ToDoNotFoundException(id);
		}
		mapper.delete(id);
	}
	
}
