package com.app.Todo.services;


import com.app.Todo.models.Task;
import com.app.Todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService
{
    private final TaskRepository taskRepository;

    public TodoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deletetask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggletask(Long id) {
        Task task=taskRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid task"));
                task.setCompleted(!task.isCompleted());
                taskRepository.save(task);
    }
}
