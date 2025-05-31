package com.app.Todo.controller;


import com.app.Todo.models.Task;
import com.app.Todo.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {
    private final TodoService todoService;

    public TaskController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public String getTasks(Model model)
    {
        List<Task> tasks=todoService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping("/")
    public String getTasks(@RequestParam String title)
    {
       todoService.createTask(title);
       return "redirect:/";
    }
    @GetMapping("{id}/delete")
    public String deleteTask(@PathVariable Long id)
    {
       todoService.deletetask(id);
       return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String getTasks(@PathVariable Long id)
    {
        todoService.toggletask(id);
        return "redirect:/";
    }
}
