# API de Tarefas - Spring Boot

### Tecnologias utilizadas

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsingle/index.html#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
  Clone o repositório:
### Como executar a aplicação
bash
Copiar código
git clone https://github.com/jimy189/GerenciamentoTarefaApiCrud.git
cd seu-repositorio

### Configure o banco de dados PostgreSQL no arquivo application.properties (ou application.properties):

spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

Endpoints
Import para o postman o arquivo:  GERENCIMENTO DE TAREFAS.postman_collection.json
### Criar Tarefa
POST /tarefa/criar

Descrição: Cria uma nova tarefa.

Corpo da Requisição:

json
Copiar código
{
"nome": "Estudar Spring",
"descricao": "Estudar Spring Boot para o projeto",
"realizado": false
}
Resposta (201 Created):

json
Copiar código
{
"id": 1,
"nome": "Estudar Spring",
"descricao": "Estudar Spring Boot para o projeto",
"realizado": false
}
### Listar Tarefas
GET /tarefa/listar

Descrição: Retorna a lista de todas as tarefas.

Resposta (200 OK):

json
Copiar código
[
{
"id": 1,
"nome": "Estudar Spring",
"descricao": "Estudar Spring Boot para o projeto",
"realizado": false
}
]
### Atualizar Tarefa
PUT /tarefa/atualizar/{id}

Descrição: Atualiza uma tarefa existente com base no id.

Corpo da Requisição:

json
Copiar código
{
"nome": "Estudar Spring Boot",
"descricao": "Estudar mais profundamente Spring Boot",
"realizado": true
}
Resposta (200 OK):

json
Copiar código
{
"id": 1,
"nome": "Estudar Spring Boot",
"descricao": "Estudar mais profundamente Spring Boot",
"realizado": true
}

Se não encontrar o id
{
"message": "Tarefa 5 não existe! "
}
git
### Deletar Tarefa
DELETE /tarefa/deletar/{id}
Descrição: Deleta uma tarefa existente com base no id.
Resposta (204 No Content).

Se não encontrar o id
{
"message": "Tarefa 5 não existe! "
}

### Exceções e Validações
A API valida os dados enviados. Se um campo obrigatório estiver vazio ou inválido, uma mensagem de erro será retornada com o código HTTP 400 Bad Request. Exemplo:

{
"status": 400,
"message": "A descrição da tarefa não pode estar vazia."
}
ok


