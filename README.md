# API Eventos Extremos

API desenvolvida em Java 21 com Spring Boot para o projeto Global Solution do primeiro semestre de 2025 da FIAP.

## Descrição
Esta API gerencia alertas e previsões de eventos extremos, permitindo operações de cadastro, consulta, atualização e remoção (CRUD) destes recursos e recursos auxiliares (usuários, tipos, etc.). Utiliza Spring Boot, Spring Data JPA, Spring Security, validação e documentação automática com OpenAPI/Swagger. A API persiste dados em um banco de dados Oracle.

## Vídeos

- [Vídeo Pitch]()
- [Vídeo de Demonstração](https://youtu.be/XRxrgYra8A8)

## Sobre nós
Desenvolvido para a Global Solution FIAP 1º Semestre 2025 por:

Grupo LLM
- Gabriel Marques de Lima Sousa - RM 554889
- Leonardo Matheus Teixeira - RM 556629
- Leonardo Menezes Parpinelli Ribas - RM 557908

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3.4.5
- Spring Data JPA
- Spring Validation
- Spring Security
- Oracle Database
- OpenAPI (Swagger)


## Pré-requisitos
- Java 21 SDK instalado e configurado
- Banco de dados Oracle (local ou remoto) com schema configurado:
  - Arquivo DDL disponível em `db/ddl.sql`
  - O JPA está no modo `validate`, ou seja, não cria o schema automaticamente, apenas valida a existência do schema
  - Arquivo DML com dados de exemplo disponível em `db/dml.sql`
- Variáveis de ambiente configuradas:
  - `DB_URL`: URL do banco de dados Oracle (no formato `host:port/sid`)
  - `DB_USER`: Usuário do banco de dados
  - `DB_PSWD`: Senha do banco de dados
  - `JWT_SECRET`: Chave secreta para geração de tokens JWT (opcional, mas recomendado para segurança)

## Como executar

1. No terminal, navegue até a pasta `api` e execute:

```powershell
gradlew.bat bootRun
```

A aplicação estará disponível em `http://localhost:8080`.

### Alternativas para execução

- **IntelliJ IDEA**: Abra o projeto e execute a classe `ApiApplication` como uma aplicação Java.
- **JAR**: Compile o projeto e execute o JAR gerado:

```powershell
gradlew.bat bootJar
java -jar build/libs/api-0.0.1-SNAPSHOT.jar
```

## Documentação da API
Acesse a documentação interativa em:

```
http://localhost:8080/swagger-ui.html
```

## Testando a API

Para utilizar a API você deve estar autenticado.
Utilize o endpoint de criação de usuário para registrar um novo usuário:

```
POST /usuarios
{
  "ativo": 1,
  "dataCadastro": "2001-05-15T18:17:07.841Z",
  "email": "nome@email.com",
  "nome": "Nome do Usuário",
  "perfil": "USUARIO",
  "senha": "senha123"
}
```
Após criar o usuário, você pode autenticar-se para obter um token JWT.
Envie uma requisição para o endpoint de login com as credenciais do usuário criado:
```
POST /usuarios/login
{
  "email": "nome@email.com",
  "senha": "senha123"
}
```
O token JWT retornado deve ser incluído no cabeçalho `Authorization` das requisições subsequentes, no formato `Bearer <token>`.

Observações:
- O token JWT tem validade de 1 hora.
- A autenticação é necessária para acessar todos os endpoints, exceto o de criação de usuário e login (aplicação pública).

## Estrutura do Projeto
- `config/`: Configurações gerais da aplicação
- `controller/`: Endpoints REST
- `dto/`: Objetos de transferência de dados
- `exception/`: Tratamento de exceções
- `mapper/`: Mapeamento entre entidades e DTOs
- `model/`: Entidades JPA
- `openapi/model/`: DTOs do OpenAPI/Swagger
- `repository/`: Repositórios JPA
- `security/`: Configuração de segurança e autenticação
- `service/`: Regras de negócio
