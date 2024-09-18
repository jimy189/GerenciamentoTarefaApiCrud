package com.com.gerenciamentotarefasapi.repository;

import com.com.gerenciamentotarefasapi.entity.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Tarefas, Long> {

}
