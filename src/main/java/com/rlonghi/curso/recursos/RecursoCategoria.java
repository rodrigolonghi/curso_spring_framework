package com.rlonghi.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rlonghi.curso.entidades.Categoria;
import com.rlonghi.curso.servicos.ServicoCategoria;

@RestController
@RequestMapping(value = "/categorias")
public class RecursoCategoria {

	@Autowired
	private ServicoCategoria servico;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos() {
		List<Categoria> list = servico.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Categoria> procurarPorId(@PathVariable Long id){
		Categoria obj = servico.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
