package com.sistema.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardDTO {

    private Long totalDiarias;

    private Long totalEspecialidades;

    private Long totalUsuarios;
    
    private Long totalListaEspera;

	private Long totalConfirmadosLista;
}
