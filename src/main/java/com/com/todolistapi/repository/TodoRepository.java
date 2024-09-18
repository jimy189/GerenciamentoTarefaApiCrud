package com.com.todolistapi.repository;

import com.com.todolistapi.entity.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Tarefas, Long> {

}
