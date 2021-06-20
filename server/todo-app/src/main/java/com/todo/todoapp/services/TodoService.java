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
        return todorepo.fetchAllTodoItems();
    }

    public TodoItem updateTodoItem(Integer id, TodoItem todoItem) {
        Optional<TodoItem> todoOpt = todorepo.fetchAllTodoItems().stream().filter(item -> item.getId().equals(id))
                .findAny();

        if (todoOpt.isPresent()) {
            TodoItem item = todoOpt.get();
            item.setDone(todoItem.isDone());
            item.setTask(todoItem.getTask());
            return item;
        }
        return null;
    }

    public TodoItem createTodoItem() {
        TodoItem newTodoItem = new TodoItem();
        newTodoItem.setDone(false);
        newTodoItem = todorepo.save(newTodoItem);
        newTodoItem.setTask("Task #" + newTodoItem.getId());
        return newTodoItem;
    }

    public void deleteTodoItem(Integer id) {
        todorepo.deleteitem(id);

    }

}
