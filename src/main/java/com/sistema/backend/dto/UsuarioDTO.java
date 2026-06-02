package com.sistema.backend.dto;

import com.sistema.backend.entity.Perfil;

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
public class UsuarioDTO {

	private Long id;

	private String nome;

	private String login;

	private Perfil perfil;

	private Boolean ativo;
}