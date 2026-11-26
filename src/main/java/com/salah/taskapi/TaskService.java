package com.salah.taskapi;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> findAll() {
        return repo.findAll();
    }

    public Task findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task create(Task task) {
        task.setId(null);
        return repo.save(task);
    }

    public Task update(Long id, Task data) {
        Task task = findById(id);
        task.setTitle(data.getTitle());
        task.setDescription(data.getDescription());
        task.setDone(data.isDone());
        return repo.save(task);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        repo.deleteById(id);
    }
}
