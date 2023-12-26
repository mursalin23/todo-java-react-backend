package com.mursalin.todos.controller;

import com.mursalin.todos.model.Todo;
import com.mursalin.todos.repository.TodoCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin
public class TodoController {

    final TodoCollectionRepository repository;

    @Autowired
    public TodoController(TodoCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Todo> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Todo findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@Valid @RequestBody Todo todo) {
        return repository.save(todo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Todo todo, @PathVariable Integer id) {
        if(!repository.exitsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        repository.save(todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        if(!repository.exitsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        repository.deleteById(id);
    }

}
