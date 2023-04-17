package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

	// Relacionamento com a classe postagem
	
	//fetch: tipo de carregamento de dados; mappedBy relacionamento com a tabela; tipo de cascata dos dados
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema") //Para não entrar em Loop infinito
	private List<Postagem> postagem;
	
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

	// GETTER E SETTERS DA COLECTION POSTAGEM
	
	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
}
