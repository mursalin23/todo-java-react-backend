package com.mursalin.todos;

import com.mursalin.todos.model.Todo;
import com.mursalin.todos.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class TodosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosApplication.class, args);
	}

	/**
	@Bean
	CommandLineRunner commandLineRunner(TodoRepository todoRepository) {

		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTime dueDate = LocalDateTime.parse("2021-10-10T10:00:00", formatter);

		return args -> {
			todoRepository.save(new Todo(null, "Complete Backend", dueDate, 1));
		};
	}
	*/

}
