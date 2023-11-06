package com.moha.todo.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;
@Component
public class Task {
    private UUID id;
    private String taskName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    private LocalDate dueDate;
    private Boolean isCompleted;

}