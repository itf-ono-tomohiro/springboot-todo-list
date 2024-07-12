package com.example.todolist.exception;

public class ToDoNotFoundException extends RuntimeException{
	
	public ToDoNotFoundException(Long id) {
		super("todoコード " + id + " は見つかりません。");
	}
	
}
