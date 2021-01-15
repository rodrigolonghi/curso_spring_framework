package com.rlonghi.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rlonghi.curso.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{
	
}
