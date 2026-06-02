package com.sistema.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.backend.dto.UsuarioDTO;
import com.sistema.backend.entity.Usuario;
import com.sistema.backend.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService service;

	@GetMapping
	public List<UsuarioDTO> listar() {

		return service.listar().stream().map(this::converterDTO).toList();
	}

	@PostMapping
	public Usuario salvar(@RequestBody Usuario usuario) {

		return service.salvar(usuario);
	}
	
	@PutMapping("/{id}")
	public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {

		return service.atualizar(id, usuario);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {

		service.deletar(id);
	}

	private UsuarioDTO converterDTO(Usuario usuario) {

		return UsuarioDTO.builder().id(usuario.getId()).nome(usuario.getNome()).login(usuario.getLogin())
				.perfil(usuario.getPerfil()).ativo(usuario.getAtivo()).build();
	}

}
