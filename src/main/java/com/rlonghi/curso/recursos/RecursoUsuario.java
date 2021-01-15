package com.rlonghi.curso.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rlonghi.curso.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {

	@GetMapping
	public ResponseEntity<Usuario> buscarTodos() {
		Usuario u = new Usuario(1L, "Maria", "maria@email.com", "9999999999", "123456");
		return ResponseEntity.ok().body(u);
	}
}
