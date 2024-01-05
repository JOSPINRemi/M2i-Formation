package org.example.dao;

import org.example.model.Task;

import java.util.List;

public interface TaskDAO {

    boolean addTask(Task task);

    List<Task> getAllTasks();

    boolean deleteTask(Long taskId);

    boolean markTaskAsCompleted(Long taskId);

    Task getTasksById(Long taskId);
    List<Task> getTasksByPersonId(Long personId);

    List<Task> getTasksByCategoryId(Long categoryId);

    void updateTask(Task task);
}
