# 🚀 Projeto Workshop MongoDB – API REST com Spring Boot

Este projeto é uma **API REST desenvolvida em Java com Spring Boot e MongoDB**, criada com o objetivo de aplicar boas práticas de desenvolvimento backend, modelagem de dados NoSQL, arquitetura em camadas, uso de DTOs, tratamento global de exceções e consultas avançadas no MongoDB.

A aplicação simula um **mini sistema de rede social**, onde usuários podem criar posts e comentários, permitindo buscas simples e avançadas com filtros por texto e data.

---

## 🧠 Visão Geral do Projeto

A aplicação permite:

- Gerenciar **Usuários**
- Criar e consultar **Posts**
- Associar **Posts a Usuários**
- Criar **Comentários embutidos** em posts
- Pesquisar posts por:
  - Título
  - Conteúdo
  - Texto dos comentários
  - Intervalo de datas
- Tratar erros de forma padronizada (RESTful)

Tudo isso seguindo uma **arquitetura em camadas**, garantindo organização, manutenção e escalabilidade do código.

---

## 🏗️ Arquitetura Utilizada

O projeto segue o padrão:

**Controller → Service → Repository**

Estrutura de pacotes:

com.joaoneto.workshopmongo

├── config → Instanciação de dados iniciais

├── dominio → Entidades do MongoDB (@Document)

├── dto → Data Transfer Objects

├── repositorios → Interfaces MongoRepository

├── servicos → Regras de negócio

├── servicos.excecao → Exceções personalizadas

├── recursos → Controllers REST

├── recursos.excecao → Tratamento global de exceções

├── recursos.util → Classes utilitárias (URL, datas)

└── WorkshopmongoApplication → Classe principal


---

## 🗃️ Modelagem do Domínio (MongoDB)

### 📌 Entidades Principais

#### 👤 Usuario
- id
- nome
- email
- lista de posts (`@DBRef` lazy)

#### 📝 Post
- id
- data
- título
- corpo
- autor (DTO)
- lista de comentários (embutidos)

#### 💬 Comentário (Subdocumento)
- texto
- data
- autor (DTO)

---

### 🔗 Relacionamentos

- Usuário → **1:N** → Posts (`@DBRef`)
- Post → **1:N** → Comentários (documentos embutidos)
- Uso de **DTOs** para evitar referências pesadas e acoplamento excessivo

✔️ Tecnologias do MongoDB aplicadas:
- `@Document`
- `@Id`
- `@DBRef`
- Documentos e subdocumentos
- Queries com `$and`, `$or`, `$regex`, `$gte`, `$lte`

---

## 📦 Tecnologias Utilizadas

- Java 8+
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Maven
- Jackson (JSON)
- Postman (testes da API)

---

## 🔗 Endpoints da API

### 👤 Usuários

- **GET** `/usuarios`  
  Lista todos os usuários

- **GET** `/usuarios/{id}`  
  Busca usuário por ID

- **POST** `/usuarios`  
  Cria um novo usuário

- **PUT** `/usuarios/{id}`  
  Atualiza nome e email do usuário

- **DELETE** `/usuarios/{id}`  
  Remove um usuário

- **GET** `/usuarios/{id}/posts`  
  Lista os posts de um usuário

---

### 📝 Posts

- **GET** `/posts/{id}`  
  Busca post por ID

- **GET** `/posts/pesquisatitulo?texto=`  
  Pesquisa posts pelo título

- **GET** `/posts/pesquisaCompleta`  
  Pesquisa avançada com filtros:
  - `texto`
  - `dataMinima`
  - `dataMaxima`

Exemplo:

/posts/pesquisaCompleta?texto=viagem&dataMinima=2025-03-01&dataMaxima=2025-03-30


---

## ⚠️ Tratamento de Exceções

A aplicação possui **tratamento global de erros**, retornando respostas padronizadas:

```json
{
  "dataHora": 1710000000000,
  "status": 404,
  "erro": "Nao encontrado",
  "mensagem": "Objeto nao encontrado",
  "caminho": "/usuarios/123"
}
```

---

## 🧮 Regras de Negócio Implementadas

- Conversão de entidades para DTOs  
- Validação de existência antes da exclusão de dados  
- Atualização parcial de usuários  
- Ajuste automático de data máxima em pesquisas  
- Consultas avançadas no MongoDB utilizando **Regex**  
- Comentários embutidos para melhor entendimento e performance  

---

## 🧪 Testes da API

A API foi testada utilizando o **Postman**, validando:

- Status HTTP corretos  
- Criação, atualização e remoção de recursos  
- Pesquisas simples e avançadas  
- Serialização JSON  
- Tratamento adequado de exceções  

---

## ▶️ Como Executar o Projeto

### 🔧 Pré-requisitos

- Java JDK 8 ou superior  
- Maven  
- MongoDB instalado e rodando localmente  
- IDE Java (IntelliJ, Eclipse ou VS Code)  

---

### 📥 Passos para Execução

1️⃣ Clone o repositório:
```bash
git clone https://github.com/seu-usuario/workshop-mongo.git

2️⃣ Abra o projeto na sua IDE

3️⃣ Verifique o arquivo application.properties:

spring.application.name=workshopmongo
spring.mongodb.uri=mongodb://localhost:27017/workshop_mongo


4️⃣ Inicie o MongoDB localmente:

mongod


5️⃣ Execute a aplicação:

java WorkshopmongoApplication


6️⃣ A API estará disponível em:

http://localhost:8080

🎯 Objetivo do Projeto

Este projeto foi desenvolvido com foco em:

Consolidar conhecimentos em Spring Boot e MongoDB

Aplicar boas práticas no desenvolvimento de APIs REST

Trabalhar com NoSQL e consultas avançadas

Demonstrar domínio de arquitetura backend

Servir como projeto de portfólio profissional

👨‍💻 Autor

João Neto
🎓 Estudante de Sistemas de Informação
🚀 Em constante evolução na área de desenvolvimento backend

🔗 LinkedIn:
https://www.linkedin.com/in/joao-rodrigues-neto-855757293/
