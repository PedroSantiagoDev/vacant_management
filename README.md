# Vacant Management

API para gerenciamento de vagas de emprego.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/jphp/vacant_management.git
   ```
2. Configure o banco de dados no arquivo `src/main/resources/application.properties`.
3. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

## Endpoints da API

### Candidato

- `POST /candidate/`: Cria um novo candidato.

**Request Body:**

```json
{
  "name": "Seu Nome",
  "username": "seu_usuario",
  "email": "seu_email@example.com",
  "password": "sua_senha",
  "description": "Sua descrição"
}
```

