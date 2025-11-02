# 🎯 Vacant Management

API REST para gerenciamento de vagas de emprego, conectando empresas e candidatos.

---

## 📋 Sobre o Projeto

Sistema completo para gerenciamento de vagas onde:
- **Empresas** podem se cadastrar, fazer login e criar vagas
- **Candidatos** podem se cadastrar e visualizar vagas disponíveis
- Autenticação via **JWT (JSON Web Token)**
- Documentação interativa com **Swagger/Scalar**

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.5**
- **Spring Security** (Autenticação JWT)
- **Spring Data JPA** (Persistência de dados)
- **PostgreSQL** (Banco de dados)
- **Lombok** (Redução de boilerplate)
- **SpringDoc OpenAPI** (Documentação Scalar)
- **Auth0 JWT** (Geração e validação de tokens)
- **Maven** (Gerenciamento de dependências)

---

## 📁 Estrutura do Projeto

```
src/main/java/br/com/jphp/vacant_management/
│
├── 🚀 VacantManagementApplication.java    # Classe principal do Spring Boot
│
├── 📦 modules/                            # Módulos de domínio
│   ├── candidate/                         # Módulo de Candidatos
│   │   ├── CandidateEntity.java          # Entidade JPA do candidato
│   │   ├── CandidateRepository.java      # Repository para acesso ao BD
│   │   ├── controllers/
│   │   │   └── CandidateController.java  # Endpoints REST (/candidate/)
│   │   └── useCases/
│   │       └── CreateCandidateUseCase.java # Lógica de criação
│   │
│   └── company/                           # Módulo de Empresas
│       ├── entities/
│       │   ├── CompanyEntity.java        # Entidade JPA da empresa
│       │   └── JobEntity.java            # Entidade JPA da vaga
│       ├── repositories/
│       │   ├── CompanyRepository.java    # Repository de empresas
│       │   └── JobRepository.java        # Repository de vagas
│       ├── controllers/
│       │   ├── CompanyController.java    # Endpoints de empresa
│       │   ├── JobController.java        # Endpoints de vagas
│       │   └── AuthCompanyController.java # Autenticação
│       ├── dto/
│       │   └── AuthCompanyDTO.java       # DTO para login
│       └── useCases/
│           ├── CreateCompanyUseCase.java # Lógica de criação
│           ├── CreateJobUseCase.java     # Lógica de vagas
│           └── AuthCompanyUseCase.java   # Lógica de autenticação
│
├── 🔒 security/                           # Configurações de Segurança
│   ├── SecurityConfig.java               # Configuração do Spring Security
│   └── SecurityFilter.java               # Filtro JWT customizado
│
├── 🔑 providers/                          # Provedores de Serviços
│   └── JWTProvider.java                  # Validação de tokens JWT
│
├── ⚙️ config/                             # Configurações
│   └── OpenApiConfig.java                # Configuração do Swagger/Scalar
│
└── ❌ exceptions/                         # Tratamento de Exceções
    ├── ErrorMessageDTO.java              # DTO de erro
    ├── UserFoundException.java           # Exceção customizada
    └── ExceptionHandlerController.java   # Handler global de exceções
```

---

## 📚 Explicação das Pastas

### 🎯 **modules/**
Contém os módulos de domínio separados por contexto de negócio:

#### **candidate/**
- Tudo relacionado aos **candidatos**
- **Entity**: Modelo de dados do candidato
- **Repository**: Acesso ao banco de dados
- **Controller**: Endpoints REST para cadastro
- **UseCase**: Regras de negócio (criar candidato, validações)

#### **company/**
- Tudo relacionado às **empresas e vagas**
- **entities/**: Modelos de Empresa e Vaga
- **repositories/**: Acesso ao banco de dados
- **controllers/**: Endpoints REST (criar empresa, vagas, autenticação)
- **dto/**: Objetos de transferência de dados (ex: login)
- **useCases/**: Regras de negócio

### 🔒 **security/**
Configurações de segurança da aplicação:
- **SecurityConfig**: Define quais rotas são públicas/privadas
- **SecurityFilter**: Intercepta requisições e valida o token JWT

### 🔑 **providers/**
Serviços auxiliares:
- **JWTProvider**: Valida e decodifica tokens JWT

### ⚙️ **config/**
Configurações gerais:
- **OpenApiConfig**: Configura o Swagger com autenticação JWT

### ❌ **exceptions/**
Tratamento centralizado de erros:
- Captura exceções e retorna respostas padronizadas

---

## 🚀 Como Executar

### 1. **Pré-requisitos**
- Java 17 ou superior
- PostgreSQL instalado e rodando
- Maven (ou use o wrapper `./mvnw`)

### 2. **Configurar Banco de Dados**
Edite o arquivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/vacant_management
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### 3. **Executar o Projeto**
```bash
# Via Maven Wrapper (recomendado)
./mvnw spring-boot:run

# Ou via Maven instalado
mvn spring-boot:run
```

### 4. **Acessar a Aplicação**
- **API**: http://localhost:8080
- **Documentação Scalar**: http://localhost:8080/docs
- **Swagger UI**: http://localhost:8080/swagger-ui/index.html

---

## 📡 Endpoints Principais

### 🔓 Públicos (sem autenticação)

#### **Criar Candidato**
```http
POST /candidate/
Content-Type: application/json

{
  "name": "João Silva",
  "username": "joaosilva",
  "email": "joao@email.com",
  "password": "senha123",
  "description": "Desenvolvedor Java"
}
```

#### **Criar Empresa**
```http
POST /company/
Content-Type: application/json

{
  "name": "Tech Corp",
  "username": "techcorp",
  "email": "contato@techcorp.com",
  "password": "senha123",
  "website": "www.techcorp.com",
  "description": "Empresa de tecnologia"
}
```

#### **Autenticar Empresa**
```http
POST /auth/company
Content-Type: application/json

{
  "username": "techcorp",
  "password": "senha123"
}

# Resposta: Token JWT
"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

### 🔒 Privados (requer autenticação)

#### **Criar Vaga**
```http
POST /job/
Authorization: Bearer {seu_token_jwt}
Content-Type: application/json

{
  "title": "Desenvolvedor Java Senior",
  "description": "Vaga para dev Java com experiência em Spring",
  "level": "SENIOR",
  "benefits": "Vale refeição, plano de saúde"
}
```

---

## 🔐 Autenticação JWT

### Como usar:

1. **Faça login** no endpoint `/auth/company`
2. **Copie o token** retornado
3. **Use o token** nas requisições protegidas:
   ```
   Authorization: Bearer {token}
   ```

### No Swagger/Scalar:
1. Acesse http://localhost:8080/docs
2. Clique no botão **"Authorize"** 🔒
3. Cole o token JWT
4. Teste os endpoints protegidos

---

## 🐳 Docker (Opcional)

Se você tiver o `docker-compose.yml` configurado:
```bash
docker-compose up -d
```

---

## 🧪 Testes

```bash
./mvnw test
```

---

## 📝 Variáveis de Ambiente

Configure no `application.properties`:
- `spring.datasource.url`: URL do PostgreSQL
- `spring.datasource.username`: Usuário do BD
- `spring.datasource.password`: Senha do BD
- `security.jwt.secret`: Chave secreta para JWT

---

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch: `git checkout -b feature/nova-feature`
3. Commit: `git commit -m 'Adiciona nova feature'`
4. Push: `git push origin feature/nova-feature`
5. Abra um Pull Request

---

## 📄 Licença

Este projeto está sob a licença MIT.

---

## 👨‍💻 Autor

Desenvolvido por JPHP

