package com.example.todolist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.model.ToDo;
import com.example.todolist.model.ToDo.Status;
import com.example.todolist.repository.ToDoRepository;

@Service
public class ToDoService {
	
	@Autowired
	ToDoRepository toDoRepository;
	
	//todolistを全件取得
	public List<ToDo> getToDos(){
		List<ToDo> allToDos = new ArrayList<>();
		toDoRepository.findAll().forEach(allToDos::add);
		return allToDos;
	}
	
	// todolistを一件取得
	public Optional<ToDo> getToDo(Long id){
		return toDoRepository.findById(id);
	}
	
	// todolistに一件追加
	public void addToDo(ToDo toDo) {
		if (toDo.getStatus() == null) {
	        toDo.setStatus(Status.NOT_STARTED);
	    }
		toDoRepository.save(toDo);
	}
	
	// todolistを一件更新
	public void updateToDo(Long id, ToDo toDo) {
		if(toDoRepository.findById(id).get( )!= null) {
			ToDo existingToDo = toDoRepository.findById(id).get();
		    if (toDo.getStatus() == null) {
		        toDo.setStatus(existingToDo.getStatus());
		    }
			toDoRepository.save(toDo);
			
		}
	}
	
	// todolistを一件削除
	public void deleteToDo(Long id) {
		if(toDoRepository.findById(id).get( )!= null) {
			toDoRepository.deleteById(id);
		}
	}
}
