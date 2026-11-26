package com.salah.taskapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceTest {

    @Autowired
    private TaskService service;

    @Test
    void createAssignsId() {
        Task task = new Task();
        task.setTitle("Write tests");
        Task saved = service.create(task);
        assertNotNull(saved.getId());
        assertEquals("Write tests", saved.getTitle());
    }

    @Test
    void findByIdThrowsWhenMissing() {
        assertThrows(TaskNotFoundException.class, () -> service.findById(9999L));
    }

    @Test
    void updateChangesFields() {
        Task task = new Task();
        task.setTitle("Old");
        Task saved = service.create(task);

        Task data = new Task();
        data.setTitle("New");
        data.setDone(true);
        Task updated = service.update(saved.getId(), data);

        assertEquals("New", updated.getTitle());
        assertTrue(updated.isDone());
    }

    @Test
    void deleteRemovesTask() {
        Task task = new Task();
        task.setTitle("To delete");
        Task saved = service.create(task);
        service.delete(saved.getId());
        assertThrows(TaskNotFoundException.class, () -> service.findById(saved.getId()));
    }
}
