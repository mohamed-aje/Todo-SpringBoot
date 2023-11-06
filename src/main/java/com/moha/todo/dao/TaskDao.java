package com.moha.todo.dao;

import com.moha.todo.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
@Component
public class TaskDao {
    private final JdbcTemplate jdbcTemplate;

    public TaskDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> getAllTasks() {
        String query="SELECT * FROM tasks";
        return jdbcTemplate.query(query,(rs, rowNum) -> mapRowToTask(rs));
    }



    public Task getTaskById(UUID id) {
    String query ="SELECT * FROM tasks WHERE id =?";
    return jdbcTemplate.queryForObject(query, new Object[]{id},(rs, rowNum) -> mapRowToTask(rs));

    }

    public void addTask(Task task) {
        String query = "INSERT INTO tasks (task_name, due_date, is_completed) VALUES (?, ?, ?)";
        jdbcTemplate.update(query,
                task.getTaskName(),
                task.getDueDate() != null ? java.sql.Date.valueOf(task.getDueDate()) : null,
                task.getCompleted() != null ? task.getCompleted() : false);
    }



    public void updateTask(UUID id, Task task) {
        String query = "UPDATE tasks SET task_name=?, due_date=?, is_completed=? WHERE id=?";
        jdbcTemplate.update(query, task.getTaskName(), task.getDueDate(), task.getCompleted(), id);
    }

    public void deleteTask(UUID id) {
        String query = "DELETE FROM tasks WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
    private Task mapRowToTask(ResultSet rs) throws SQLException {
        Task task =new Task();
        task.setId((UUID) rs.getObject("id"));
        task.setTaskName(rs.getString("task_name"));
        task.setDueDate(rs.getDate("due_date").toLocalDate());
        task.setCompleted(rs.getBoolean("is_completed"));
        return task;
    }


}
