package com.rlonghi.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rlonghi.curso.entidades.PedidoItem;

public interface RepositorioPedidoItem extends JpaRepository<PedidoItem, Long>{
	
}
