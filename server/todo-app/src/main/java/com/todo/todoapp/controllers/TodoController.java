package com.todo.todoapp.controllers;

import java.util.ArrayList;
import java.util.List;

import com.todo.todoapp.domain.TodoItem;
import com.todo.todoapp.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/api/todoItems")
    public ResponseEntity<?> fetchAllTodoItems() {
        List<TodoItem> todoItems = new ArrayList<>();
        todoItems = todoService.fetchAllTodoItems();
        return ResponseEntity.status(HttpStatus.OK).body(todoItems);
        // return ResponseEntity.ok(todoItems);
    }

    @PostMapping("/api/todoItems")
    public ResponseEntity<?> createNewTodoItem() {
        TodoItem todoItem = todoService.createTodoItem();
        System.out.println(todoItem.getTask());
        return ResponseEntity.ok(todoItem);
    }

    @PutMapping("/api/todoItems/{id}")
    public ResponseEntity<?> UpdateTodoItem(@PathVariable Integer id, @RequestBody TodoItem todoItem) {
        TodoItem UpdatedTodoItem = todoService.updateTodoItem(id, todoItem);
        return ResponseEntity.ok().body(UpdatedTodoItem);
    }

    @DeleteMapping("/api/todoItems/{id}")
    public ResponseEntity<?> deleteTodoItem(@PathVariable Integer id) {
        todoService.deleteTodoItem(id);

        return ResponseEntity.ok("ok");
    }

}
