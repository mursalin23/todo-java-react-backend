package com.mursalin.todos.repository;

import com.mursalin.todos.model.Todo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoCollectionRepository {

    private final List<Todo> todoList = new ArrayList<>();

    public TodoCollectionRepository() {}

    public List<Todo> findAll() {
        return todoList;
    }

    public Optional<Todo> findById(Integer id) {
        return todoList.stream().filter(todo -> todo.id().equals(id)).findFirst();
    }

    public Todo save(Todo todo) {
        todoList.removeIf(t -> t.id().equals(todo.id()));
        todoList.add(todo);
        return todo;
    }

    public boolean exitsById(Integer id) {
        return todoList.stream().anyMatch(todo -> todo.id().equals(id));
    }

    @PostConstruct
    private void init() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime dueDate = LocalDateTime.parse("2023-10-10T10:00:00", formatter);
        todoList.add(new Todo(
                1,
                "Complete Backend",
                dueDate,
                1
        ));
    }

    public void deleteById(Integer id) {
        todoList.removeIf(todo -> todo.id().equals(id));
    }
}
