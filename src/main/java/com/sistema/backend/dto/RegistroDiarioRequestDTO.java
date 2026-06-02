package com.sistema.backend.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroDiarioRequestDTO {

    private LocalDate data;

    private Integer totalAgendados;

    private Integer compareceram;

    private String observacao;
    
    private Integer interno;

    private Integer externo;
    
    private Integer interconsulta;

    private Long especialidadeId;
    
    private String nomeProfissional;
}