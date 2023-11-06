package com.moha.todo.service;

import com.moha.todo.dao.TaskDao;
import com.moha.todo.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
 private final TaskDao taskDao;

    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public List<Task> getAllTasks(){
        return taskDao.getAllTasks();
    }

    public Task getTaskById(UUID id){
        return taskDao.getTaskById(id);
    }
    public void addTask(Task task){
        taskDao.addTask(task);
    }
    public void updateTask(UUID id,Task
            task){
        taskDao.updateTask(id,task);
    }
    public void deleteTask(UUID id ){
        taskDao.deleteTask(id);
    }


}
