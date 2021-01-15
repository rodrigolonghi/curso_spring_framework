package com.rlonghi.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rlonghi.curso.entidades.Pedido;
import com.rlonghi.curso.servicos.ServicoPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursoPedido {

	@Autowired
	private ServicoPedido servico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodos() {
		List<Pedido> list = servico.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Pedido> procurarPorId(@PathVariable Long id){
		Pedido obj = servico.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
