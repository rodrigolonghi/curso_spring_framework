package com.rlonghi.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rlonghi.curso.entidades.Produto;
import com.rlonghi.curso.servicos.ServicoProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursoProduto {

	@Autowired
	private ServicoProduto servico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos() {
		List<Produto> list = servico.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Produto> procurarPorId(@PathVariable Long id){
		Produto obj = servico.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
