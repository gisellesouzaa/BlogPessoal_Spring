package com.generation.blogpessoal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_tema")
public class Tema {
	
	//CRIAR ATRIBUTOS E CONFIGURAR AS PROPRIEDADES DO BD
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message= "O atributo 'descricao' é obrigatório!")
	@Size(min = 5, max = 255, message = "O atributo 'descricao' deve ter no mínimo 5 e no máximo 255 caracteres")
	private String descricao;

	// GETTER E SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
