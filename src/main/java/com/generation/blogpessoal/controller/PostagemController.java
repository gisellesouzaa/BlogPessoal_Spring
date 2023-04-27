package com.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;
import com.generation.blogpessoal.repository.TemaRepository;

import jakarta.validation.Valid;

@RestController //Define a classe como tipo controladora 
@RequestMapping("/postagens") //Responde as requisições de /postagens
@CrossOrigin(origins = "*", allowedHeaders = "*") //Autorizar requisições de outros locais; * = aceita todas as requisições, depois pode trocar pelo endereço do front end
public class PostagemController {

		//----------- Injeção de dependências -----------//
		//É a inversão de controle - transfere a responsabilidade para o Spring criar objetos, instanciar, apagar, consultar dentro do BD
		
		@Autowired
		private PostagemRepository postagemRepository;
		
		@Autowired
		private TemaRepository temaRepository;
		
	
		//----------- Método buscar todos-----------//
	
		@GetMapping
		public ResponseEntity<List<Postagem>> getAll(){
			return ResponseEntity.ok(postagemRepository.findAll());
			//oK retorna o código 200
			
		} //Equivalente a: SELECT * FROM tb_postagens
		
		//----------- Método Procurar por ID-----------//
		@GetMapping("/{id}")
		public ResponseEntity<Postagem> getById(@PathVariable Long id){
			
			return postagemRepository.findById(id)
					.map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());	
		} //Equivalente a: SELECT * FROM tb_postagens WHERE id = ?;
		
		
		
		//-----------Consultar Postagens por Título-----------//
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
			
			return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
				
		} //Equivalente a: SELECT * FROM tb_postagens where titulo like "%titulo%";
		
		

		//----------- Método Cadastrar Nova Postagem-----------//
		@PostMapping
		public ResponseEntity<Postagem> post(@Valid @RequestBody Postagem postagem){
			if (temaRepository.existsById(postagem.getTema().getId()))
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(postagemRepository.save(postagem));
				
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tema não existe!", null);
		}//Equivalente a: INSERT INTO tb_postagens (titulo, texto, data) VALUES ("Título", "Texto", CURRENT_TIMESTAMP());
		
		
		
		//-----------Método Atualizar a Postagem-----------//
		@PutMapping
		public ResponseEntity<Postagem> put(@Valid @RequestBody Postagem postagem) {
			if (postagemRepository.existsById(postagem.getId())){
				
				if (temaRepository.existsById(postagem.getTema().getId()))
					return ResponseEntity.status(HttpStatus.OK)
							.body(postagemRepository.save(postagem));
				
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tema não existe!", null);
				
			}			
				
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		} //Equivalente a: UPDATE tb_postagens SET titulo = "titulo", texto = "texto", data = CURRENT_TIMESTAMP() WHERE id = id;

		
		
		//-----------Método deletar a postagem-----------//
		@ResponseStatus(HttpStatus.NO_CONTENT)
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {

			//Optional para não apagar algo inexistente
			Optional<Postagem> postagem = postagemRepository.findById(id);
					
			if(postagem.isEmpty())
					throw new ResponseStatusException(HttpStatus.NOT_FOUND);
					
			postagemRepository.deleteById(id);
			
		} //Equivalente a: DELETE FROM tb_postagens WHERE id = id;
		
		
}
