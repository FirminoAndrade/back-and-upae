package com.sistema.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sistema.backend.dto.LoginRequestDTO;
import com.sistema.backend.dto.LoginResponseDTO;
import com.sistema.backend.entity.Usuario;
import com.sistema.backend.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final UsuarioRepository repository;

	private final PasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {

		Usuario usuario = repository.findByLogin(dto.getLogin())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

		boolean senhaCorreta = passwordEncoder.matches(dto.getSenha(), usuario.getSenha());

		if (!senhaCorreta) {

			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login ou senha inválidos");
		}

		LoginResponseDTO response = new LoginResponseDTO(

				usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getPerfil());

		return ResponseEntity.ok(response);
	}
}
