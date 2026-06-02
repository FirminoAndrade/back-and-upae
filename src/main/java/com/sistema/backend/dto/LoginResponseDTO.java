package com.sistema.backend.dto;

import com.sistema.backend.entity.Perfil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDTO {

    private Long id;

    private String nome;

    private String login;

    private Perfil perfil;
}
