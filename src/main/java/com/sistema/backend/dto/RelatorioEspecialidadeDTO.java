package com.sistema.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RelatorioEspecialidadeDTO {

    private String especialidade;

    private String profissional;

    private Long totalAgendados;

    private Long compareceram;

    private Long faltaram;

    private Long interno;

    private Long interconsulta;
    
    private Long externo;
    
}