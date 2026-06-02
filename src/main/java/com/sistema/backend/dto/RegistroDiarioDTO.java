package com.sistema.backend.dto;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroDiarioDTO {

    private Long id;

    private LocalDate data;

    private Integer totalAgendados;

    private Integer compareceram;

    private Integer faltaram;

    private String observacao;
    
    private Integer interno;

    private Integer externo;
    
    private Integer interconsulta;

    private Long especialidadeId;

    private String especialidadeNome;

    private String nomeProfissional;
}


