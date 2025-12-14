# 🧑‍💼 Sistema de Gestão de Férias - API REST

API desenvolvida para a prova técnica de gestão de férias de servidores públicos.

## 📋 Descrição do Projeto

Sistema que permite a um servidor público consultar seus períodos de férias e visualizar dados básicos dos pagamentos associados a esses períodos.

## 🎨 Protótipo de Baixa Fidelidade

[Ver protótipo no Excalidraw](https://excalidraw.com/#json=EQmHYn4I55A3cXq5jloWd,ZqTidL45H6FvKXOja0Xhjw)

## 🎯 Funcionalidades

✅ Visualizar períodos de férias de um servidor  
✅ Ver detalhes específicos de um período de férias  
✅ Consultar informações de pagamento relacionadas às férias  
✅ Criar novos servidores e períodos de férias

## 🧩 Modelagem de Dados

O sistema utiliza **3 tabelas principais**:

### 1. Tabela `servidor`
Representa o funcionário

### 2. Tabela `ferias`
Representa os períodos de descanso.

**Relacionamento:** Um Servidor pode ter muitas Férias (1:N)

### 3. Tabela `pagamento`
Informações financeiras.

**Relacionamento:** Um período de Férias tem um registro de Pagamento (1:1)

### Diagrama de Relacionamentos

```
SERVIDOR (1) ----< (N) FERIAS (1) ----< (1) PAGAMENTO
```

![Modelo de Dados](docs/images/modelo-dados.jpg)

## 🔗 Endpoints da API

### Servidores

#### `GET /servidores`
Lista todos os servidores cadastrados.

#### `GET /servidores/{id}`
Busca um servidor específico por ID.

#### `POST /servidores`
Cria um novo servidor.

### Férias por Servidor

#### `GET /servidores/{servidorId}/ferias`
Retorna todos os períodos de férias de um servidor específico.

#### `POST /servidores/{servidorId}/ferias`
Cria um novo período de férias para um servidor.

### Férias

#### `GET /ferias/{id}`
Retorna detalhes de um período específico de férias, incluindo informações de pagamento.

## 🐳 Execução com Docker

### Pré-requisitos
- Docker Desktop (Windows) rodando
- Docker Compose

> ⚠️ **Importante:** Certifique-se de que o Docker Desktop está rodando no Windows antes de executar os comandos.

### Passos para executar

1. **Clone o repositório**
```bash
git clone https://github.com/Wertheins/ferias-api
cd ferias-api
```

2. **Suba os containers**
```bash
docker-compose up --build
```

O Docker irá compilar o projeto automaticamente dentro do container.

### Acessando a aplicação

- **API:** http://localhost:8081
- **Documentação Swagger:** http://localhost:8081/swagger-ui.html
- **MySQL:** localhost:3308
  - Usuário: `root`
  - Senha: `L123@`
  - Database: `ferias_db`

> ⚠️ **Nota:** Credenciais apenas para ambiente de desenvolvimento local.

### Parando os containers

```bash
docker-compose down
```

Para remover os volumes (dados do banco):
```bash
docker-compose down -v
```

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **MySQL 8.0**
- **Lombok**
- **SpringDoc OpenAPI (Swagger)**
- **Docker & Docker Compose**
- **Maven**

## 📁 Estrutura do Projeto

```
ferias-api/
├── src/
│   └── main/
│       └── java/
│           └── com/lucas/feriasapi/
│               ├── controller/        # Controllers REST
│               ├── dto/              # Data Transfer Objects
│               ├── model/            # Entidades JPA
│               ├── repository/       # Repositories
│               └── service/          # Lógica de negócio
├── Dockerfile
├── docker-compose.yml
└── pom.xml
```

## 🧪 Testando a API

### 1. Criar um servidor
```bash
curl -X POST http://localhost:8081/servidores \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "matricula": "12345",
    "email": "joao@exemplo.com"
  }'
```

### 2. Criar férias para o servidor
```bash
curl -X POST http://localhost:8081/servidores/1/ferias \
  -H "Content-Type: application/json" \
  -d '{
    "dataInicio": "2025-07-01",
    "dataFim": "2025-07-30",
    "status": "APROVADO",
    "pagamento": {
      "valorTotal": 6000.00,
      "dataPagamento": "2025-06-25",
      "statusPagamento": "PAGO"
    }
  }'
```

### 3. Listar férias do servidor 
```bash
curl "http://localhost:8081/servidores/1/ferias?page=0&size=10"
```

### 4. Listar todos os servidores 
```bash
curl "http://localhost:8081/servidores?page=0&size=10"
```

### 5. Ver detalhes de um período específico
```bash
curl http://localhost:8081/ferias/1
```

## 👥 Autor

Lucas - Prova Técnica de Desenvolvedor


