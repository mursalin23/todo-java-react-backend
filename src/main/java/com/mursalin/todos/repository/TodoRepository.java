package com.mursalin.todos.repository;

import com.mursalin.todos.model.Todo;
import org.springframework.data.repository.ListCrudRepository;

public interface TodoRepository extends ListCrudRepository<Todo, Integer> {

}