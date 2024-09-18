package com.com.gerenciamentotarefasapi.dto.Response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TarefaResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private boolean realizado;
}
