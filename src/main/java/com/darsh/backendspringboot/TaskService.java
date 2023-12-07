package com.darsh.backendspringboot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Optional<Task> getTaskById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }

    public Task createTask(Task task) {
        task.setId(tasks.size() + 1); // Auto-increment ID (example)
        tasks.add(task);
        return task;
    }

    public Optional<Task> updateTask(int id, Task updatedTask) {
        Optional<Task> existingTaskOptional = getTaskById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDone(updatedTask.isDone());
            return Optional.of(existingTask);
        }
        return Optional.empty();
    }

    public boolean deleteTask(int id) {
        Optional<Task> taskToDelete = getTaskById(id);
        if (taskToDelete.isPresent()) {
            tasks.remove(taskToDelete.get());
            return true;
        }
        return false;
    }
}
