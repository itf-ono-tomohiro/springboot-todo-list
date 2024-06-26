package com.example.todolist.exception;

public class ToDoNotFoundException extends RuntimeException{
	
	private final Long serialVersionUID = 1L;
	
	public ToDoNotFoundException(Long id) {
		super("todoコード" + id + "は見つかりません。");
	}
	
}
