package com.generation.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Postagem;

@Repository //Está em desuso. Porém precisa para validação na plataforma da Gen
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	// Implementa os métodos pré definidos no JPA no PostagemRepository
	//<Postagem> = Classe criada no model
	//<Long> = Tipo defido para o Id na classe Postagem 
}
