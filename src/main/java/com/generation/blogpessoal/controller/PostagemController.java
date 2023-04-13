package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

@RestController //Define a classe como tipo controladora 
@RequestMapping("/postagens") //Responde as requisições de /postagens
@CrossOrigin(origins = "*", allowedHeaders = "*") //Autorizar requisições de outros locais; * = aceita todas as requisições, depois pode trocar pelo endereço do front end
public class PostagemController {

		//Injeção de dependências - Inversão de controle - transfere a responsabilidade para o Spring criar objetos, instanciar, apagar, consultar dentro do BD
		@Autowired
		private PostagemRepository postagemRepository;
		
		//Objeto com lista de postagem
		@GetMapping
		public ResponseEntity<List<Postagem>> getAll(){
			return ResponseEntity.ok(postagemRepository.findAll());
			//oK retorna o código 200
			//Equivalente a: SELECT * FROM tb_postagens
			
		}
}
