package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity //Comando para criar a tabela no BD
@Table(name = "tb_postagens") //Equivalente a: CREATE TABLE tb_postagens
public class Postagem {

	//CRIAR ATRIBUTOS E CONFIGURAR AS PROPRIEDADES DO BD
	
	@Id //indica que é a chave primaria da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Tornar o Id autoincremente
	private Long id;
	
	@NotBlank (message= "O Atributo 'título' é obrigatório!") //Não permitir nulo e espaço vazio
	@Size(min = 5, max = 100, message = "O atributo título deve ter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;
	
	@NotBlank (message= "O Atributo 'texto' é obrigatório!") //Não permitir nulo e espaço vazio
	@Size(min = 10, max = 1000, message = "O atributo título deve ter no mínimo 10 e no máximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp //Quando alterar a informação, atualizar automaticamente a data e hora. 
	private LocalDateTime data;

	// GETTER E SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	

	
}
