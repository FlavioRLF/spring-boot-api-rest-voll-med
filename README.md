# 🏥 Voll Med API

Este projeto é uma API REST desenvolvida com Spring Boot para o gerenciamento de médicos em uma clínica. A aplicação permite cadastrar, listar, atualizar, excluir e inativar médicos de forma segura e eficiente, com suporte à exclusão lógica.

---

## 📌 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.3
- Spring Data JPA
- PostgreSQL
- Flyway (controle de migrações de banco)
- Hibernate
- Bean Validation (Jakarta)
- SLF4J / Logback (log)
- Lombok

---

## 🚀 Como executar o projeto

### Pré-requisitos

- Java 17 instalado
- PostgreSQL rodando localmente (porta padrão 5432)
- Maven ou sua IDE configurada
- Flyway configurado para gerenciar as migrações

### 1. Clonar o projeto

```bash
git clone https://github.com/seu-usuario/spring-boot-api-rest-voll-med.git
cd spring-boot-api-rest-voll-med
```

### 2. Criar o banco de dados

Acesse o PostgreSQL e crie o banco:

```sql
CREATE DATABASE clinica;
```

### 3. Configurar o `application.properties` (se necessário)

Localize ou crie o arquivo `src/main/resources/application.properties` com:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/clinica
spring.datasource.username=postgres
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
```

### 4. Executar o projeto

Na raiz do projeto:

```bash
./mvnw spring-boot:run
```

Ou na sua IDE (IntelliJ, Eclipse etc.) execute a classe `ApiApplication`.

---

## 📚 Funcionalidades

### ✅ Cadastro de médico

- `POST /medico`  
Cadastra um novo médico com dados pessoais e de endereço.

### ✅ Listagem de médicos

- `GET /medico/lista`  
Retorna todos os médicos cadastrados.

- `GET /medico/dto`  
Retorna os médicos em formato DTO.

- `GET /medico/paginacao/dto`  
Lista médicos ativos com paginação.

### ✅ Atualização de médico

- `PUT /medico/atualiza`  
Atualiza informações parciais de um médico. Suporta atualização seletiva de telefone e endereço.

### ✅ Exclusão

- `DELETE /medico/{id}`  
Remove permanentemente um médico (exclusão física).

- `DELETE /medico/exclusaoLogica/{id}`  
Marca o médico como inativo (exclusão lógica via flag `ativo = false`).

---

## ✍️ Observações

- O campo `ativo` controla se o médico está disponível (true) ou excluído logicamente (false).
- Todas as alterações em entidades são realizadas dentro de transações com `@Transactional`.
- A persistência é feita por JPA/Hibernate, com mapeamento automático e lazy loading.

---