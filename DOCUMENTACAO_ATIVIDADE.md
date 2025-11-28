# 📋 Documentação da Atividade - Solo Livre

## 1. Arquitetura da Solução

### 1.1 Tecnologia Mobile Adotada
- **Plataforma:** Android Nativo
- **Linguagem:** Kotlin
- **Framework UI:** Material Design 3
- **Padrão Arquitetural:** Single Activity + Multiple Fragments

### 1.2 Estrutura Geral do Backend
```
┌────────────────────────────────────────────────────────────────┐
│                        BACKEND (API REST)                       │
├────────────────────────────────────────────────────────────────┤
│  /api/usuarios      → Cadastro, Login, Perfil                  │
│  /api/instrumentos  → CRUD de instrumentos musicais            │
│  /api/cursos        → CRUD de cursos de música                 │
│  /api/compras       → Registro e consulta de compras           │
└────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌────────────────────────────────────────────────────────────────┐
│                    BANCO DE DADOS (SQLite)                      │
├────────────────────────────────────────────────────────────────┤
│  Tabelas: Usuario, Instrumento, Curso, Professor, Compra       │
└────────────────────────────────────────────────────────────────┘
```

### 1.3 Fluxo de Dados (Sequência e Comunicação com APIs)

```
┌─────────────┐                    ┌─────────────┐                    ┌─────────────┐
│   USUÁRIO   │                    │  APLICATIVO │                    │   BACKEND   │
│  (Mobile)   │                    │   (Kotlin)  │                    │    (API)    │
└──────┬──────┘                    └──────┬──────┘                    └──────┬──────┘
       │                                  │                                  │
       │  1. Abre o app                   │                                  │
       │─────────────────────────────────►│                                  │
       │                                  │                                  │
       │                                  │  2. GET /api/instrumentos        │
       │                                  │─────────────────────────────────►│
       │                                  │                                  │
       │                                  │  3. Retorna lista JSON           │
       │                                  │◄─────────────────────────────────│
       │                                  │                                  │
       │  4. Exibe lista de produtos      │                                  │
       │◄─────────────────────────────────│                                  │
       │                                  │                                  │
       │  5. Clica em "Comprar"           │                                  │
       │─────────────────────────────────►│                                  │
       │                                  │                                  │
       │                                  │  6. POST /api/compras            │
       │                                  │─────────────────────────────────►│
       │                                  │                                  │
       │                                  │  7. Confirma compra              │
       │                                  │◄─────────────────────────────────│
       │                                  │                                  │
       │  8. Exibe "Compra realizada!"    │                                  │
       │◄─────────────────────────────────│                                  │
       │                                  │                                  │
```

---

## 2. Modelagem do Banco de Dados

### 2.1 Diagrama Entidade-Relacionamento (DER)

```
┌─────────────────┐                                    ┌─────────────────┐
│     USUÁRIO     │                                    │   INSTRUMENTO   │
├─────────────────┤                                    ├─────────────────┤
│ PK id           │                                    │ PK id           │
│    nome         │                                    │    nome         │
│    email        │───────────────┐                    │    categoria    │
│    senha        │               │                    │    preco        │
│    telefone     │               │      ┌────────────►│    descricao    │
│    data_cadastro│               │      │             │    estoque      │
└─────────────────┘               │      │             │    avaliacao    │
                                  │      │             └─────────────────┘
                                  │      │
                                  ▼      │
                           ┌─────────────────┐
                           │     COMPRA      │
                           ├─────────────────┤
                           │ PK id           │
                           │ FK id_usuario   │◄─────── Usuário (1) ──── (N) Compra
                           │ FK id_item      │
                           │    tipo_item    │◄─────── Compra (N) ──── (1) Instrumento
                           │    quantidade   │         Compra (N) ──── (1) Curso
                           │    valor_total  │
                           │    data_compra  │
                           │    status       │
                           └─────────────────┘
                                  ▲      │
                                  │      │
┌─────────────────┐               │      │             ┌─────────────────┐
│    PROFESSOR    │               │      │             │      CURSO      │
├─────────────────┤               │      │             ├─────────────────┤
│ PK id           │               │      └────────────►│ PK id           │
│    nome         │───────────────┼────────────────────│ FK id_professor │
│    especialidade│               │                    │    nome         │
│    bio          │               │                    │    categoria    │
│    avaliacao    │               │                    │    preco        │
└─────────────────┘               │                    │    duracao      │
        │                         │                    │    num_aulas    │
        │                         │                    │    descricao    │
        └─────────────────────────┘                    │    certificado  │
          Professor (1) ──── (N) Curso                 │    avaliacao    │
                                                       └─────────────────┘
```

### 2.2 Relacionamentos Explicados

| Relacionamento | Cardinalidade | Descrição |
|----------------|---------------|-----------|
| Usuário → Compra | 1:N | Um usuário pode fazer várias compras |
| Compra → Instrumento | N:1 | Várias compras podem ser de um mesmo instrumento |
| Compra → Curso | N:1 | Várias compras podem ser de um mesmo curso |
| Professor → Curso | 1:N | Um professor pode ministrar vários cursos |

### 2.3 Tabelas com Atributos, Tipos e Relacionamentos

#### Tabela: USUARIO
| Atributo | Tipo | Tamanho | Nulo | Chave | Descrição |
|----------|------|---------|------|-------|-----------|
| id | INT | - | NÃO | PK | Identificador único auto-incremento |
| nome | VARCHAR | 100 | NÃO | - | Nome completo do usuário |
| email | VARCHAR | 150 | NÃO | UK | E-mail único (usado no login) |
| senha | VARCHAR | 255 | NÃO | - | Senha criptografada |
| telefone | VARCHAR | 20 | SIM | - | Telefone de contato |
| data_cadastro | DATETIME | - | NÃO | - | Data/hora do cadastro |

#### Tabela: INSTRUMENTO
| Atributo | Tipo | Tamanho | Nulo | Chave | Descrição |
|----------|------|---------|------|-------|-----------|
| id | INT | - | NÃO | PK | Identificador único |
| nome | VARCHAR | 150 | NÃO | - | Nome do instrumento |
| categoria | VARCHAR | 50 | NÃO | - | Ex: Violão, Teclado, Bateria |
| preco | DECIMAL | 10,2 | NÃO | - | Preço em R$ |
| descricao | TEXT | - | SIM | - | Descrição detalhada |
| estoque | INT | - | NÃO | - | Quantidade disponível |
| avaliacao | DECIMAL | 2,1 | NÃO | - | Nota média (0.0 a 5.0) |
| imagem_url | VARCHAR | 255 | SIM | - | URL da imagem |

#### Tabela: PROFESSOR
| Atributo | Tipo | Tamanho | Nulo | Chave | Descrição |
|----------|------|---------|------|-------|-----------|
| id | INT | - | NÃO | PK | Identificador único |
| nome | VARCHAR | 100 | NÃO | - | Nome do professor |
| especialidade | VARCHAR | 100 | NÃO | - | Instrumento/área |
| bio | TEXT | - | SIM | - | Biografia |
| avaliacao | DECIMAL | 2,1 | NÃO | - | Nota média |

#### Tabela: CURSO
| Atributo | Tipo | Tamanho | Nulo | Chave | Descrição |
|----------|------|---------|------|-------|-----------|
| id | INT | - | NÃO | PK | Identificador único |
| id_professor | INT | - | NÃO | FK | Referência ao professor |
| nome | VARCHAR | 150 | NÃO | - | Nome do curso |
| categoria | VARCHAR | 50 | NÃO | - | Ex: Violão, Piano |
| preco | DECIMAL | 10,2 | NÃO | - | Preço em R$ |
| duracao | INT | - | NÃO | - | Duração em horas |
| num_aulas | INT | - | NÃO | - | Quantidade de aulas |
| descricao | TEXT | - | SIM | - | Descrição do curso |
| certificado | BOOLEAN | - | NÃO | - | Inclui certificado? |
| avaliacao | DECIMAL | 2,1 | NÃO | - | Nota média |

#### Tabela: COMPRA
| Atributo | Tipo | Tamanho | Nulo | Chave | Descrição |
|----------|------|---------|------|-------|-----------|
| id | INT | - | NÃO | PK | Identificador único |
| id_usuario | INT | - | NÃO | FK | Referência ao usuário |
| id_item | INT | - | NÃO | - | ID do instrumento ou curso |
| tipo_item | ENUM | - | NÃO | - | 'instrumento' ou 'curso' |
| quantidade | INT | - | NÃO | - | Quantidade comprada |
| valor_total | DECIMAL | 10,2 | NÃO | - | Valor total da compra |
| data_compra | DATETIME | - | NÃO | - | Data/hora da compra |
| status | ENUM | - | NÃO | - | pendente/pago/enviado/entregue |

---

## 3. Desenvolvimento do Backend (Versão Inicial)

### 3.1 Endpoints Implementados

#### Endpoint 1: Listagem de Instrumentos
```
GET /api/instrumentos

Descrição: Retorna lista de todos os instrumentos disponíveis

Resposta (200 OK):
[
  {
    "id": 1,
    "nome": "Violão Yamaha C40",
    "categoria": "Violões",
    "preco": 649.90,
    "descricao": "Violão clássico para iniciantes",
    "estoque": 15,
    "avaliacao": 4.8
  },
  ...
]
```

#### Endpoint 2: Listagem de Cursos
```
GET /api/cursos

Descrição: Retorna lista de todos os cursos disponíveis

Resposta (200 OK):
[
  {
    "id": 1,
    "idProfessor": 1,
    "nome": "Violão Completo - Do Zero ao Avançado",
    "categoria": "Violão",
    "preco": 199.90,
    "duracao": 12,
    "numAulas": 48,
    "certificado": true,
    "avaliacao": 4.9
  },
  ...
]
```

#### Endpoint 3: Cadastro de Usuário
```
POST /api/usuarios/cadastro

Body (JSON):
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123456",
  "telefone": "(11) 99999-9999"
}

Resposta (201 Created):
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "mensagem": "Usuário cadastrado com sucesso"
}
```

---

## 4. Primeira Versão Funcional (MVP)

### 4.1 Fluxo de Navegação

```
┌─────────────────────────────────────────────────────────────┐
│                     TELA INICIAL (Início)                    │
│  ┌─────────────────────────────────────────────────────┐   │
│  │  🎸 Solo Livre - Sua jornada musical começa aqui    │   │
│  │  [Barra de Busca]                                    │   │
│  │  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ │   │
│  │  🔥 OFERTA ESPECIAL                                  │   │
│  │  Violão Clássico Premium - R$ 899,90                │   │
│  │  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ │   │
│  │  Categorias: [🎸] [🎹] [🥁] [🎺]                     │   │
│  │  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ │   │
│  │  Cursos Populares                                    │   │
│  │  • Violão do Zero - R$ 199                          │   │
│  │  • Piano Clássico - R$ 249                          │   │
│  └─────────────────────────────────────────────────────┘   │
│                                                             │
│  ┌─────────┬─────────┬─────────┐                           │
│  │ 🏠 Início│ 🏪 Loja │ 📚 Cursos│  ◄── Menu de Navegação   │
│  └─────────┴─────────┴─────────┘                           │
└─────────────────────────────────────────────────────────────┘
         │                │                │
         │                ▼                ▼
         │    ┌───────────────┐   ┌───────────────┐
         │    │  TELA LOJA    │   │ TELA CURSOS   │
         │    │  Instrumentos │   │ Lista cursos  │
         │    │  Grid produtos│   │ Filtros       │
         │    │  Filtros      │   │ Preços        │
         │    └───────────────┘   └───────────────┘
         │
         ▼
    (Tela atual)
```

### 4.2 Funcionalidades Implementadas

| # | Funcionalidade | Descrição | Status |
|---|----------------|-----------|--------|
| 1 | Navegação | Menu inferior com 3 abas (Início, Loja, Cursos) | ✅ |
| 2 | Listagem de Instrumentos | Grid de produtos com imagem, nome, preço, avaliação | ✅ |
| 3 | Listagem de Cursos | Lista de cursos com professor, duração, preço | ✅ |
| 4 | Categorias | Filtros por categoria de instrumento | ✅ |
| 5 | Busca | Campo de busca nas telas | ✅ |
| 6 | Cards Interativos | Botões de "Comprar" e "Iniciar Curso" | ✅ |

---

## 5. Repositório Git

### Estrutura do Projeto
```
sololivre/
├── app/
│   └── src/main/
│       ├── java/com/example/solo/
│       │   ├── MainActivity.kt
│       │   ├── HomeFragment.kt
│       │   ├── LojaFragment.kt
│       │   ├── CursosFragment.kt
│       │   └── data/
│       │       ├── models/
│       │       │   ├── Usuario.kt
│       │       │   ├── Instrumento.kt
│       │       │   ├── Curso.kt
│       │       │   ├── Professor.kt
│       │       │   └── Compra.kt
│       │       └── repository/
│       │           ├── InstrumentoRepository.kt
│       │           └── CursoRepository.kt
│       └── res/
│           ├── layout/
│           ├── drawable/
│           ├── values/
│           └── menu/
├── build.gradle.kts
├── README.md
└── DOCUMENTACAO_ATIVIDADE.md
```

### Instruções para Rodar

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/sololivre.git

# 2. Abra no Android Studio
# File → Open → Selecione a pasta

# 3. Aguarde sincronização do Gradle

# 4. Execute no emulador ou dispositivo
# Clique em Run (▶️)

# 5. Para gerar APK
./gradlew assembleDebug
```

---

## 📱 Screenshots

[Adicionar capturas de tela do app aqui]

---

## 👥 Equipe

| Nome | RA | Função |
|------|-----|--------|
| [Aluno 1] | [RA] | Desenvolvimento Mobile |
| [Aluno 2] | [RA] | Backend / Banco de Dados |
| [Aluno 3] | [RA] | Documentação / Testes |

---

**Data de Entrega:** [Data]
**Disciplina:** [Nome da Disciplina]
**Professor(a):** [Nome do Professor]

