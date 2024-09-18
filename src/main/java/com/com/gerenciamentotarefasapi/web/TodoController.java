package com.com.gerenciamentotarefasapi.web;

import com.com.gerenciamentotarefasapi.dto.Request.TarefaRequestDTO;
import com.com.gerenciamentotarefasapi.dto.Response.TarefaResponseDTO;
import com.com.gerenciamentotarefasapi.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // Criar Tarefa - Retorna 201 Created
    @PostMapping("/criar")
    public ResponseEntity<TarefaResponseDTO> create(@Valid @RequestBody TarefaRequestDTO tarefa) {
        TarefaResponseDTO novaTarefa = todoService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    // Listar Tarefas - Retorna 200 OK com a lista
    @GetMapping("/listar")
    public ResponseEntity<List<TarefaResponseDTO>> list() {
        List<TarefaResponseDTO> tarefas = todoService.listarTarefas();
        return ResponseEntity.ok(tarefas);
    }

    // Atualizar Tarefa - Retorna 200 OK após a atualização
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<TarefaResponseDTO> update(@PathVariable Long id, @Valid @RequestBody TarefaRequestDTO tarefa) {
        TarefaResponseDTO tarefaAtualizada = todoService.atualizarTarefa(id, tarefa);
        return ResponseEntity.ok(tarefaAtualizada);
    }

    // Deletar Tarefa - Retorna 204 No Content se a tarefa for deletada
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.deletarTarefa(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
