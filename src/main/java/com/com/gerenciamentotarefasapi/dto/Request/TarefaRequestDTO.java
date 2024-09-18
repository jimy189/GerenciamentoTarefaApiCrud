package com.com.gerenciamentotarefasapi.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class TarefaRequestDTO {


    @NotBlank(message = "O nome da tarefa não pode estar vazio.")
    private String nome;
    @NotBlank(message = "A descrição da tarefa não pode estar vazia.")
    private String descricao;
    private boolean realizado;
}
