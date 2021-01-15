package com.rlonghi.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rlonghi.curso.entidades.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long>{
	
}
