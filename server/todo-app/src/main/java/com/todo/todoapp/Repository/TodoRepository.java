package com.todo.todoapp.Repository;

import com.todo.todoapp.domain.TodoItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoItem, Integer> {

}
