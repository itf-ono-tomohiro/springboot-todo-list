package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.exception.ToDoNotFoundException;
import com.example.todolist.model.ToDo;
import com.example.todolist.service.ToDoServiceImpl;

@RestController
@RequestMapping("/todos")
public class ToDoController {
	
	@Autowired
	ToDoServiceImpl toDoService;
	
	@GetMapping
	public List<ToDo> getToDos(){
		return toDoService.getToDos();
	}
	
	@GetMapping("/{id}")
	public ToDo getToDo(@PathVariable("id") Long id) {
		return toDoService.getToDo(id);
	}
	
	@PostMapping
	public void postToDo(@Validated @RequestBody ToDo toDo) {
		toDoService.createToDo(toDo);
	}
	
	@PutMapping("/{id}")
	public void updateToDo(@PathVariable("id") Long id, @Validated @RequestBody ToDo toDo){
		if(toDoService.getToDo(id) == null) {
			throw new ToDoNotFoundException(id);
		}
		toDo.setId(id);
		toDoService.updateToDo(toDo);
	}
	
	@DeleteMapping("/{id}")
	public void deleteToDo(@PathVariable Long id) {
		toDoService.delete(id);
	}
}
