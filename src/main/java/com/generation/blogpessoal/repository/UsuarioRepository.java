package com.generation.blogpessoal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogpessoal.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//Optinal pois pode ter ou não o usuario
	public Optional<Usuario> findByUsuario(String usuario);

}
