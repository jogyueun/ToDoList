package com.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoEntity,Long> {
    @Query("SELECT t FROM ToDoEntity t WHERE t.deleted = false ORDER BY t.Id DESC ")
    List<ToDoEntity> findAllNoDeleted();
}
