package com.sistema.backend.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "registro_diario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroDiario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate data;

	private Integer totalAgendados;

	private Integer compareceram;

	private Integer faltaram;

	private String observacao;
	
	private Integer interno;

	private Integer externo;
	
	private Integer interconsulta;

	private LocalDateTime createdAt;
	
	private String nomeProfissional;

	@ManyToOne
	@JoinColumn(name = "especialidade_id")
	private Especialidade especialidade;

	@PrePersist
	public void prePersist() {

		this.createdAt = LocalDateTime.now();

		calcularFaltaram();
	}

	@PreUpdate
	public void preUpdate() {

		calcularFaltaram();
	}

	private void calcularFaltaram() {

		if (totalAgendados != null && compareceram != null) {

			this.faltaram = totalAgendados - compareceram;
		}
	}
}
