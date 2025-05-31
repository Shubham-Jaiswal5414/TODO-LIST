package com.app.Todo.repository;

import com.app.Todo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long>
{

}
