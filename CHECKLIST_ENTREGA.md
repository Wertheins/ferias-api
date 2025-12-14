# 📝 Checklist de Entrega da Prova Técnica

## ✅ Itens Concluídos

- [x] Modelagem de dados (3 tabelas)
- [x] API REST com Spring Boot
- [x] Endpoints principais implementados
- [x] Dockerfile criado
- [x] docker-compose.yml configurado
- [x] README.md com instruções
- [x] Documentação do modelo de dados

## 🚀 Próximos Passos para Entrega

### 1. Testar a aplicação localmente

```bash
# Compilar o projeto
mvnw clean package -DskipTests

# Subir os containers
docker-compose up

# Testar os endpoints
curl http://localhost:8080/servidores
```

### 2. Criar o Protótipo no Excalidraw

**Link:** https://excalidraw.com/

**Telas necessárias:**
1. Tela de Login (simples)
2. Listagem de períodos de férias
3. Detalhes do período (com info de pagamento)

**Lembre-se de:**
- Exportar como imagem ou compartilhar o link
- Mostrar a navegação entre as telas
- Incluir no repositório (pasta `prototipo/`)

### 3. Preparar o repositório GitHub

```bash
# Inicializar git (se ainda não foi feito)
git init

# Adicionar todos os arquivos
git add .

# Fazer o commit
git commit -m "feat: implementação completa da API de férias"

# Adicionar o remote (substitua pela URL do seu repo)
git remote add origin https://github.com/SEU-USUARIO/ferias-api.git

# Push para o GitHub
git push -u origin main
```

### 4. Adicionar Colaboradores no GitHub

**Usuários para adicionar:**
- https://github.com/gabrielbtera
- https://github.com/lefeistauer

**Como adicionar:**
1. Acesse: `https://github.com/SEU-USUARIO/ferias-api/settings/access`
2. Clique em **"Add people"** ou **"Invite a collaborator"**
3. Digite os usernames:
   - `gabrielbtera`
   - `lefeistauer`
4. Selecione a permissão: **"Write"** ou **"Admin"**
5. Clique em **"Add [username] to this repository"**

### 5. Estrutura final do repositório

```
ferias-api/
├── src/                          # Código fonte
├── prototipo/                    # Adicionar aqui o protótipo do Excalidraw
│   └── prototipo-baixa-fidelidade.png
├── Dockerfile
├── docker-compose.yml
├── README.md                     # Instruções principais
├── MODELO_DADOS.md              # Documentação do modelo
├── dados-exemplo.sql            # Dados para teste
└── pom.xml
```

### 6. Verificações Finais

Antes de enviar, certifique-se de que:

- [ ] O projeto compila sem erros
- [ ] Os containers sobem corretamente com `docker-compose up`
- [ ] Os endpoints retornam dados corretos
- [ ] O README está completo e claro
- [ ] O protótipo está incluído no repositório
- [ ] Os colaboradores foram adicionados
- [ ] O repositório está público ou acessível aos avaliadores

## 📦 Estrutura de Entrega

O repositório deve conter:

1. ✅ **Código da API** (Spring Boot) - CONCLUÍDO
2. ✅ **Modelo de dados** (MODELO_DADOS.md) - CONCLUÍDO
3. ⏳ **Protótipo em baixa fidelidade** (Excalidraw) - PENDENTE
4. ✅ **Docker** (Dockerfile + docker-compose.yml) - CONCLUÍDO
5. ✅ **README** com instruções - CONCLUÍDO

## 🕐 Prazo de Entrega

**Data limite:** 14/12/2025 às 18:00

## 📧 Confirmação de Entrega

Após adicionar os colaboradores, envie uma mensagem confirmando:

> "Repositório pronto para avaliação: https://github.com/SEU-USUARIO/ferias-api
> 
> Colaboradores adicionados: @gabrielbtera e @lefeistauer
> 
> Para executar:
> 1. `mvnw clean package -DskipTests`
> 2. `docker-compose up`
> 3. Acessar: http://localhost:8080"

---

## 🎯 O que foi implementado

### Endpoints Principais

1. **GET /servidores/{id}/ferias** → Lista períodos de férias do servidor
2. **GET /ferias/{id}** → Detalhes do período incluindo pagamento
3. **POST /servidores** → Criar novo servidor (adicional)
4. **POST /servidores/{id}/ferias** → Criar novo período (adicional)

### Tecnologias

- Java 21
- Spring Boot 4.0.0
- MySQL 8.0
- Docker & Docker Compose
- Lombok
- JPA/Hibernate

### Diferenciais Implementados

✨ **Endpoints POST** (não obrigatório, mas pedido como ponto positivo)
✨ **DTOs** para evitar problemas de serialização
✨ **Documentação detalhada** do modelo de dados
✨ **Dados de exemplo** prontos para teste
✨ **Relacionamentos bem definidos** (1:N e 1:1)
