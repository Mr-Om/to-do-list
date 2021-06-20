package com.todo.todoapp.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.todo.todoapp.domain.TodoItem;

import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {
    private List<TodoItem> todoItems = new ArrayList<>();
    private Integer counter = 0;

    public List<TodoItem> fetchAllTodoItems() {
        if (todoItems.size() == 0) {
            TodoItem item1 = new TodoItem();
            item1.setId(counter++);
            item1.setTask("Task #1");
            item1.setDone(false);
            todoItems.add(item1);
        }
        return todoItems;
    }

    public TodoItem save(TodoItem newItem) {
        newItem.setId(++counter);
        todoItems.add(newItem);
        return newItem;
    }

    public void deleteitem(Integer id) {

        todoItems = todoItems.stream().filter((item) -> !item.getId().equals(id)).collect(Collectors.toList());

    }
}
