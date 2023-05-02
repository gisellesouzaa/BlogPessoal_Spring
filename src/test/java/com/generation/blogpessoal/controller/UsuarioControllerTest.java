package com.generation.blogpessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.model.UsuarioLogin;
import com.generation.blogpessoal.repository.UsuarioRepository;
import com.generation.blogpessoal.service.UsuarioService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // Usa a porta http disponivel
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

	// Injeção de dependencia

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TestRestTemplate testRestTemplate;
	// cria as requisições / insomminia

	@BeforeAll // executar antes de tudo
	void start() {

		// garantir que o ambiente esta controlado. Sem dados antigos.
		usuarioRepository.deleteAll();

		// criar novo usuário
		usuarioService.cadastrarUsuario(new Usuario(0L, "Root", "root@root.com", "rootroot", "-"));
	}

	@Test
	@DisplayName("😎 Deve cadastrar novo usuário")
	public void deveCriarUsuario() {

		HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(
				new Usuario(0L, "Patricio Antunis", "patricio@gmail.com", "12345678", "-"));

		ResponseEntity<Usuario> corpoResposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST,
				corpoRequisicao, Usuario.class);
		// endereço recurso endponint, verbo, corpo, retorno

		assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());
	}

	@Test
	@DisplayName("😎 Não deve permitir a duplicação de usuário")
	public void naoDeveDuplicarUsuario() {

		usuarioService.cadastrarUsuario(new Usuario(0L, "Maria", "maria@gmail.com", "12345678", "-"));

		HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(
				new Usuario(0L, "Maria", "maria@gmail.com", "12345678", "-"));

		ResponseEntity<Usuario> corpoResposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST,
				corpoRequisicao, Usuario.class);
		// endponint, verbo Http, corpoRequisição, retorno

		assertEquals(HttpStatus.BAD_REQUEST, corpoResposta.getStatusCode());
	}

	@Test
	@DisplayName("😎 Deve atualizar os dados do usuário")
	public void deveAtualizarUmUsuario() {

		// Optional recebe dados cadastrados para depois recuperarmos o ID gerado pelo  sistema
		Optional<Usuario> usuarioCadastrado = usuarioService
				.cadastrarUsuario(new Usuario(0L, "Juliana", "juliana@gmail.com", "12345678", "-"));

		HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(new Usuario(usuarioCadastrado.get().getId(),
				"Juliana Andrews", "juliana_andrews@gmail.com", "12345678", "-"));

		ResponseEntity<Usuario> corpoResposta = testRestTemplate.withBasicAuth("root@root.com", "rootroot")
				.exchange("/usuarios/atualizar", HttpMethod.PUT, corpoRequisicao, Usuario.class);

		assertEquals(HttpStatus.OK, corpoResposta.getStatusCode());
	}

	@Test
	@DisplayName("😎 Deve mostrar todos os usuário")
	public void deveMostrarTodosUsuario() {

		usuarioService.cadastrarUsuario(new Usuario(0L, 
				"Guilherme", "guilherme@gmail.com", "12345678", "-"));

		usuarioService.cadastrarUsuario(new Usuario(0L, 
				"Hugo", "hugo@gmail.com", "12345678", "-"));

		//String pois pegará a lista em formato json
		ResponseEntity<String> resposta = testRestTemplate
				.withBasicAuth("root@root.com", "rootroot")
				.exchange("/usuarios/all", HttpMethod.GET, null, String.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Test
	@DisplayName("😎 Deve procurar usuário por ID")
	public void deveProcurarUsuarioPorID() {

		Optional<Usuario> usuarioCadastrado1 = usuarioService.cadastrarUsuario(new Usuario(0L, 
				"Amanda", "amanda@gmail.com", "12345678", "-"));
	
		ResponseEntity<Usuario> resposta = testRestTemplate
				.withBasicAuth("root@root.com", "rootroot")
				.exchange("/usuarios/" + usuarioCadastrado1.get().getId(), HttpMethod.GET, null, Usuario.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Test
	@DisplayName("😎 Deve logar usuário")
	public void deveLogarUsuario() {
		
		//Criar usuario e objeto
		usuarioService.cadastrarUsuario(new Usuario(0L, "Talita", "talita@gmail.com", "12345678", "-"));
		
		//Criar objeto
		UsuarioLogin usuarioLogin = new UsuarioLogin("talita@gmail.com", "12345678");
		
		//corpo requisição
		HttpEntity<Optional<UsuarioLogin>> corpoRequisicao = new HttpEntity<Optional<UsuarioLogin>>(Optional.of(usuarioLogin));
		
		//resposta
		ResponseEntity<UsuarioLogin> corpoResposta = testRestTemplate
				.exchange("/usuarios/logar", HttpMethod.POST, corpoRequisicao, UsuarioLogin.class);
		
		assertEquals(HttpStatus.OK, corpoResposta.getStatusCode());


		
	}
	
}
