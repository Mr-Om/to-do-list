package com.todo.todoapp.services;

import java.util.List;
import java.util.Optional;

import com.todo.todoapp.Repository.TodoRepository;
import com.todo.todoapp.domain.TodoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todorepo;

    public List<TodoItem> fetchAllTodoItems() {
        return (List<TodoItem>) todorepo.findAll();
    }

    public TodoItem updateTodoItem(Integer id, TodoItem todoItem) {
        Optional<TodoItem> found = todorepo.findById(id);
        System.out.println(found.get());
        if (found.isPresent()) {
            found.get().setIsDone(todoItem.getIsDone());
            found.get().setTask(todoItem.getTask());
            todorepo.save(found.get());
            return found.get();
        }
        return null;
    }

    public TodoItem createTodoItem() {
        TodoItem newTodoItem = new TodoItem("Task", 0);
        newTodoItem = todorepo.save(newTodoItem);
        return newTodoItem;
    }

    public void deleteTodoItem(Integer id) {
        todorepo.deleteById(id);
    }

}
