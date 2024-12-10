package com.fatec.compromisso.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CompromissoRequest( 

    @NotBlank(message = "Não pode estar vázio.")
    String descricao,

    @NotBlank(message = "Local não pode estar vazio")
    @Size(min = 2, message = "Tamanho minimo deve ser de 2 caracteres!")
    String local,
    
    @NotBlank(message = "Local não pode estar vazio")
    @FutureOrPresent(message = "A data deve ser no futuro ou no presente.")
    String data
    ) {
    
}
