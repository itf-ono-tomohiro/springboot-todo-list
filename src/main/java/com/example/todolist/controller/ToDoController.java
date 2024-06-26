package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.exception.ToDoNotFoundException;
import com.example.todolist.model.ToDo;
import com.example.todolist.service.ToDoService;

@RestController
public class ToDoController {
	
	@Autowired
	ToDoService toDoService;
	
	@GetMapping("/todos")
	public List<ToDo> getToDos(){
		return toDoService.getToDos();
	}
	
	@GetMapping("/todos/{id}")
	public ToDo getToDo(@PathVariable("id") Long id){
		return toDoService.getToDo(id).orElseThrow(() -> new ToDoNotFoundException(id));
	}
	
	@PostMapping("/todos")
	public void addToDo(@RequestBody ToDo toDo){
		toDoService.addToDo(toDo);
	}
	
	@PutMapping("/todos/{id}")
	public void updateToDo(@RequestBody ToDo toDo,@PathVariable("id") Long id){
		toDoService.updateToDo(id, toDo);
	}
	
	@DeleteMapping("/todos/{id}")
	public void deleteToDo(@PathVariable("id") Long id) {
		toDoService.deleteToDo(id);
	}

}
