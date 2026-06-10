package com.sistema.backend.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaEsperaDTO {

	private Long id;

	private String nome;

	private String prontuario;

	private String telefone;

	private LocalDate dataNascimento;

	private String especialidade;

	private Boolean confirmado;
}
