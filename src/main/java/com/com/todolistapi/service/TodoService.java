package com.com.todolistapi.service;

import com.com.todolistapi.dto.Request.TarefaRequestDTO;
import com.com.todolistapi.dto.Response.TarefaResponseDTO;
import com.com.todolistapi.entity.Tarefas;
import com.com.todolistapi.exception.BadRequestException;
import com.com.todolistapi.exception.ResourceNotFoundException;
import com.com.todolistapi.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TarefaResponseDTO> listarTarefas() {
        Sort sort = (Sort.by(Sort.Direction.ASC, "id"));
        List<Tarefas> tarefas = todoRepository.findAll(sort);
        // Convertendo a lista de Tarefas para TarefaResponseDTO
        return tarefas.stream()
                .map(tarefa -> new TarefaResponseDTO(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao(), tarefa.isRealizado()))
                .collect(Collectors.toList());
    }

    public TarefaResponseDTO criarTarefa(TarefaRequestDTO tarefaRequest) {
        Tarefas novaTarefa = new Tarefas(tarefaRequest.getNome(), tarefaRequest.getDescricao(), tarefaRequest.isRealizado());
        Tarefas tarefaCriada = todoRepository.save(novaTarefa);

        return new TarefaResponseDTO(tarefaCriada.getId(), tarefaCriada.getNome(), tarefaCriada.getDescricao(), tarefaCriada.isRealizado());
    }


    public TarefaResponseDTO atualizarTarefa(Long id, TarefaRequestDTO tarefaRequest) {
        return todoRepository.findById(id)
                .map(tarefaExistente -> {
                    tarefaExistente.setNome(tarefaRequest.getNome());
                    tarefaExistente.setDescricao(tarefaRequest.getDescricao());
                    tarefaExistente.setRealizado(tarefaRequest.isRealizado());
                    Tarefas tarefaAtualizada = todoRepository.save(tarefaExistente);

                    return new TarefaResponseDTO(tarefaAtualizada.getId(), tarefaAtualizada.getNome(), tarefaAtualizada.getDescricao(), tarefaAtualizada.isRealizado());
                })
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID %d não existe!".formatted(id)));
    }

    public void deletarTarefa(Long id) {
        todoRepository.findById(id).ifPresentOrElse(
                (existingTodo) -> todoRepository.delete(existingTodo),
                () -> { throw new ResourceNotFoundException("Tarefa %d não existe! ".formatted(id)); }
        );


    }
}
