package com.moha.todo.api;

import com.moha.todo.model.Task;
import com.moha.todo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable UUID id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public void addPerson(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable UUID id, @RequestBody Task task) {
        taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable UUID id) {
        taskService.deleteTask(id);
    }



}
