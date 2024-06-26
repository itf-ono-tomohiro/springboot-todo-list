package com.example.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.todolist.model.ToDo;

// DBにアクセスするためのインターフェース
@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long>{
}
