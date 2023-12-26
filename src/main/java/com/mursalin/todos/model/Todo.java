package com.mursalin.todos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Todo(
        Integer id,
        @NotBlank
        String description,
        LocalDateTime duedate,
        Integer priority) {
}
