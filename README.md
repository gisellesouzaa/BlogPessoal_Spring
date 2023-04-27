<h1 align="center"> Blog Pessoal</h1>

<p align="center">Projeto desenvolvido no Framework Spring durante  o Bootcamp Desenvolvedor Java Fullstack da Generation Brasil</p>

<p align="center">🚧 Aplicação em construção 🚧<p>

<h2> 🛠 Tecnologias: </h2>

As seguintes ferramentas foram usadas na construção do projeto:

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=flat&logo=mysql&logoColor=white)

<h2> Diagrama de Classes do Projeto: </h2>

<div align="center"><img src="https://i.imgur.com/G71SCJ0.png" title="source: imgur.com" /></div>
<br />

O Projeto é composto por 3 Recursos (*Conjunto de Classes e Interfaces responsáveis por mapear um tipo de Objeto e persistir no Banco de dados Relacional*) e uma Classe auxiliar:

| Classe           | Descrição                                                    |
| ---------------- | ------------------------------------------------------------ |
| **Postagem**     | Recurso responsável por definir Objeto Postagem (posts) do Blog Pessoal |
| **Tema**         | Recurso responsável por classificar as postagens através do Objeto Tema |
| **Usuario**      | Recurso responsável por definir o Objeto Usuário, que poderá acessar e criar postagens no Blog Pessoal |
| **UsuarioLogin** | Classe auxiliar, que será utilizada para efetuar login no Blog Pessoal |

Cada Recurso irá gerar uma tabela no Banco de dados da aplicação. A Classe auxiliar não irá gerar uma tabela no Banco de dados da aplicação porquê ela servirá de Classe auxiliar na implementação da Segurança da aplicação. 

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

<h2> Autor: </h2>

<img alt="Giselle Souza" title="Giselle Souza" src="https://github.com/gisellesouzaa.png" height="100" width="100"/>

Feito com ❤️ por Giselle Souza. 👋
<br>
<a href="https://www.linkedin.com/in/giselle-de-souza-gabriel/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-05122A?style=for-the-flat&logo=linkedin&logoColor=white" target="_blank"></a>
