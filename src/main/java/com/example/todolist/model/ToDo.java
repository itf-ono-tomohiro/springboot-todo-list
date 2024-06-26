package com.example.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="todolist")
public class ToDo {
	
	public enum Status{
		NOT_STARTED,
		IN_PROGRESS,
		COMPLETED
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String details;
	
	@Enumerated(EnumType.STRING)
    private Status status;

}