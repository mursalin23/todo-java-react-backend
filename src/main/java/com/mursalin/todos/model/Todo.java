package com.mursalin.todos.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Todo(
        @Id
        Integer id,
        @NotBlank
        String description,
        LocalDateTime duedate,
        Integer priority) {
}
