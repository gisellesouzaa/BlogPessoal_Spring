<h1 align="center"> Blog Pessoal</h1>

<div align="center">
API de Blog Pessoal desenvolvido no Framework Spring durante o Bootcamp Desenvolvedor Java Fullstack da Generation Brasil<br>
No projeto foi implementada a arquiteturas API Rest e a comunicação com os bancos de dados MySQL e PostgreSQL.<br>
Além dos metódos de postagens, filtros, atualizaçõs e exclusões, a aplicação conta com verificações de segurança e validações de testes unitários.
</div>
 
<h2> 🛠 Tecnologias: </h2>

As seguintes ferramentas foram usadas na construção do projeto:

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=flat&logo=mysql&logoColor=white)
![Insomnia](https://img.shields.io/badge/Insomnia-5C2D91?style=flat&logo=insomnia%20studio&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat&logo=postgresql&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/Render-1CE783?style=flat&logo=render&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-6DB33F?style=flat&logo=swagger&logoColor=white)

### 💬 Assuntos abordados:
- Programação Orientada a objetos  
- Desenvolvimento Ágil de Software com SCRUM 
- Criação de API’s Java com Arquitetura MVC e REST 
- Modelagem de Dados
- Terminal + Git e GitHub
- Teste de requisições HTTP (Get, Post, Put e Delete)  
- Banco de Dados Relacionais, MySQL e PostgreSQL
- Maven
- Spring Data JPA
- Spring Boot
- Spring Security (JWT)
- Web Services REST com Spring
- Testes unitários em Java
- Deploy de Aplicações

<h2> EndPoints: </h2>
  <img alt="Imagem com os EndPoints da Aplicação" src="EndPoints_da_Aplicação.png" />

---
<h2> Diagrama de Classes do Projeto: </h2>

```mermaid
classDiagram
class Tema {
  - id : Long
  - descricao : String
  - postagem : List ~Postagem~
  + getAll()
  + getById(Long id)
  + getByDescricao(String descricao)
  + postTema(Tema tema)
  + putTema(Tema tema)
  + deleteTema(Long id)
}
class Postagem {
  - id : Long
  - titulo : String
  - texto: String
  - data: LocalDateTime
  - senha : String
  - tema : Tema
  - usuario : Usuario
  + getAll()
  + getById(Long id)
  + getByTitulo(String titulo)
  + postPostagem(Postagem postagem)
  + putPostagem(Postagem postagem)
  + deleteTema(Long id)
}
class Usuario {
  - id : Long
  - nome : String
  - usuario : String
  - senha : String
  - foto : String
  - postagem : List ~Postagem~
  + getAll()
  + getById(Long id)
  + autenticarUsuario(UsuarioLogin usuarioLogin)
  + cadastrarUsuario(Usuario usuario)
  + atualizarUsuario(Usuario usuario)
}
class UsuarioLogin{
  - id : Long
  - nome : String
  - usuario : String
  - senha : String
  - foto : String
  - token : String
}
Tema --> Postagem
Usuario --> Postagem
```

O Projeto é composto por 3 Recursos (*Conjunto de Classes e Interfaces responsáveis por mapear um tipo de Objeto e persistir no Banco de dados Relacional*) e uma Classe auxiliar:

| Classe           | Descrição                                                    |
| ---------------- | ------------------------------------------------------------ |
| **Postagem**     | Recurso responsável por definir Objeto Postagem (posts) do Blog Pessoal |
| **Tema**         | Recurso responsável por classificar as postagens através do Objeto Tema |
| **Usuario**      | Recurso responsável por definir o Objeto Usuário, que poderá acessar e criar postagens no Blog Pessoal |
| **UsuarioLogin** | Classe auxiliar, que será utilizada para efetuar login no Blog Pessoal |

Cada Recurso gera uma tabela no Banco de dados da aplicação. A Classe auxiliar não gera uma tabela no Banco de dados da aplicação porquê ela serve de Classe auxiliar na implementação da Segurança da aplicação. 

<h2> Diagrama de Entidade e Relacionamentos: </h2>

<div align="center"><img src="https://i.imgur.com/zmzehFU.png" title="source: imgur.com" /></div>

<h2> Relacionamento entre as classes: </h2>

<div align="center"><img src="https://i.imgur.com/5p6IKku.png" title="source: imgur.com" /></div>
<br />

<h2> Dependências utilizadas no projeto: </h2>

| Dependência               | Descrição                                                    |
| ------------------------- | ------------------------------------------------------------ |
| **Spring Web**            | Essa dependência fornece todas as Bibliotecas necessárias para criar um projeto WEB e trabalhar com o protocolo HTTP/HTTPS. |
| **Spring Boot Dev Tools** | Permite a atualização do projeto em tempo real durante o processo de Desenvolvimento da aplicação. |
| **Validation**            | Fornece um conjunto de anotações que permitem validar os Atributos das Classes da Camada Model. |
| **Spring Data JPA**       | Java Persistence API (JPA) é uma Biblioteca que armazena e recupera Objetos, que foram persistidos (armazenados) em um Bancos de Dados.      |
| **MySQL Driver**          | Responsável pela conexão entre nossa aplicação e o Banco de Dados MySQL. <br />Se alterarmos o Sistema Gerenciador de Banco de dados - SGBD da aplicação (Postgre SQL, SQL server, Oracle, entre outros) precisaremos alterar o Driver da nossa aplicação. |
| **Starter Security**      | Responsável por todas as dependências relacionadas à segurança do Spring. Dentro desta dependência, existem outras 3 dependências: spring-security-core, spring-security-config e spring-security-web |
| **JWT**                   | As dependências jjwt-api, jjwt-impl e jjwt-jackson são responsáveis por gerar e validar o Token JWT.|
| **PostgreSQL**            | Responsável pela conexão entre nossa aplicação e o Banco de Dados na Nuvem. O PostgreSQL é utiliza como SGBD pelo Render.|
| **Spring Doc**            | Fornece as anotações do OpenAPI e oferece suporte ao Swagger, permitindo a disponibilização da UI e facilitando a construção da documentação da API.|

### 💻 Demostração:

Para testar a API entre no link abaixo com: <br>
usuário: root@root.com <br>
senha: rootroot <br>

<a href="https://blogpessoal-0iib.onrender.com" target="_blank"><img align="center" alt="Testar Aplicação" src="https://img.shields.io/badge/Clique_aqui_para_testar_a_página-6DB33F?style=flat&logo=playerhite"></a>

<p>Obs: Por se tratar de uma hospegem gratuita, o sistema pode apresentar lentidão para carregar a página.</p>

<h2> Autor: </h2>

<img alt="Giselle Souza" title="Giselle Souza" src="https://github.com/gisellesouzaa.png" height="100" width="100"/>

Feito com ❤️ por Giselle Souza. 👋
<br>
<a href="https://www.linkedin.com/in/giselle-de-souza-gabriel/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-05122A?style=for-the-flat&logo=linkedin&logoColor=white" target="_blank"></a>
