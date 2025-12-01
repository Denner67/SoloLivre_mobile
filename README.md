# 🎸 Solo Livre - App de Instrumentos Musicais e Cursos

Aplicativo móvel para venda de instrumentos musicais e cursos de música.

## 📱 Tecnologias Utilizadas

- **Plataforma:** Android Nativo
- **Linguagem:** Kotlin
- **SDK Mínimo:** Android 7.0 (API 24)
- **SDK Alvo:** Android 14 (API 34)
- **IDE:** Android Studio

### Bibliotecas
- Material Design 3
- AndroidX AppCompat
- ConstraintLayout
- RecyclerView
- CardView
- ViewBinding

---

## 🏗️ Arquitetura da Solução

### Estrutura do Frontend Mobile
```
app/
├── src/main/
│   ├── java/com/example/solo/
│   │   ├── MainActivity.kt          # Activity principal
│   │   ├── HomeFragment.kt           # Tela Início
│   │   ├── LojaFragment.kt           # Tela Loja
│   │   └── CursosFragment.kt         # Tela Cursos
│   └── res/
│       ├── layout/                   # Layouts XML
│       ├── drawable/                 # Ícones e shapes
│       ├── values/                   # Cores, strings, temas
│       └── menu/                     # Menu de navegação
```

### Estrutura Geral do Backend
```
backend/
├── api/
│   ├── usuarios/          # Endpoints de usuários
│   ├── instrumentos/      # Endpoints de instrumentos
│   ├── cursos/            # Endpoints de cursos
│   └── compras/           # Endpoints de compras
├── database/
│   └── sololivre.db       # Banco SQLite
└── models/
    ├── Usuario.kt
    ├── Instrumento.kt
    ├── Curso.kt
    └── Compra.kt
```

### Fluxo de Dados (Comunicação com APIs)
```
┌─────────────┐     HTTP/JSON      ┌─────────────┐     SQL      ┌─────────────┐
│   Mobile    │ ◄────────────────► │   Backend   │ ◄──────────► │   Database  │
│   (Kotlin)  │   GET/POST/PUT     │   (API)     │   CRUD       │   (SQLite)  │
└─────────────┘                    └─────────────┘              └─────────────┘

Sequência de uma Compra:
1. Usuário seleciona produto no app
2. App envia POST /api/compras com dados
3. Backend valida e salva no banco
4. Backend retorna confirmação
5. App exibe mensagem de sucesso
```

---

## 🗄️ Modelagem do Banco de Dados

### Diagrama Entidade-Relacionamento (DER)

```
┌─────────────┐          ┌─────────────┐          ┌─────────────┐
│   USUÁRIO   │          │   COMPRA    │          │ INSTRUMENTO │
├─────────────┤          ├─────────────┤          ├─────────────┤
│ PK id       │──────┐   │ PK id       │   ┌──────│ PK id       │
│ nome        │      │   │ FK id_usuario│◄──┘      │ nome        │
│ email       │      └──►│ FK id_item  │          │ categoria   │
│ senha       │          │ tipo_item   │◄─────────│ preco       │
│ telefone    │          │ quantidade  │          │ descricao   │
│ data_cadastro│         │ valor_total │          │ estoque     │
└─────────────┘          │ data_compra │          │ avaliacao   │
                         │ status      │          └─────────────┘
                         └─────────────┘
                               ▲
┌─────────────┐                │              ┌─────────────┐
│  PROFESSOR  │                │              │    CURSO    │
├─────────────┤                │              ├─────────────┤
│ PK id       │────────────────┼─────────────►│ PK id       │
│ nome        │                │              │ FK id_professor│
│ especialidade│               └──────────────│ nome        │
│ bio         │                               │ categoria   │
│ avaliacao   │                               │ preco       │
└─────────────┘                               │ duracao     │
                                              │ num_aulas   │
                                              │ descricao   │
                                              │ certificado │
                                              └─────────────┘

RELACIONAMENTOS:
• Usuário (1) ──────── (N) Compra
• Compra (N) ──────── (1) Instrumento  [quando tipo_item = 'instrumento']
• Compra (N) ──────── (1) Curso        [quando tipo_item = 'curso']
• Professor (1) ───── (N) Curso
```

### Tabelas com Atributos, Tipos e Relacionamentos

#### Tabela: USUARIO
| Atributo | Tipo | Restrições | Descrição |
|----------|------|------------|-----------|
| id | INTEGER | PK, AUTO_INCREMENT | Identificador único |
| nome | VARCHAR(100) | NOT NULL | Nome completo |
| email | VARCHAR(150) | NOT NULL, UNIQUE | E-mail (login) |
| senha | VARCHAR(255) | NOT NULL | Senha criptografada |
| telefone | VARCHAR(20) | NULL | Telefone de contato |
| data_cadastro | DATETIME | DEFAULT NOW() | Data do cadastro |

#### Tabela: INSTRUMENTO
| Atributo | Tipo | Restrições | Descrição |
|----------|------|------------|-----------|
| id | INTEGER | PK, AUTO_INCREMENT | Identificador único |
| nome | VARCHAR(150) | NOT NULL | Nome do instrumento |
| categoria | VARCHAR(50) | NOT NULL | Categoria (violão, teclado, etc.) |
| preco | DECIMAL(10,2) | NOT NULL | Preço em reais |
| descricao | TEXT | NULL | Descrição detalhada |
| estoque | INTEGER | DEFAULT 0 | Quantidade em estoque |
| avaliacao | DECIMAL(2,1) | DEFAULT 0 | Nota média (0-5) |
| imagem_url | VARCHAR(255) | NULL | URL da imagem |

#### Tabela: PROFESSOR
| Atributo | Tipo | Restrições | Descrição |
|----------|------|------------|-----------|
| id | INTEGER | PK, AUTO_INCREMENT | Identificador único |
| nome | VARCHAR(100) | NOT NULL | Nome do professor |
| especialidade | VARCHAR(100) | NOT NULL | Instrumento/área |
| bio | TEXT | NULL | Biografia |
| avaliacao | DECIMAL(2,1) | DEFAULT 0 | Nota média (0-5) |

#### Tabela: CURSO
| Atributo | Tipo | Restrições | Descrição |
|----------|------|------------|-----------|
| id | INTEGER | PK, AUTO_INCREMENT | Identificador único |
| id_professor | INTEGER | FK → PROFESSOR(id) | Professor responsável |
| nome | VARCHAR(150) | NOT NULL | Nome do curso |
| categoria | VARCHAR(50) | NOT NULL | Categoria do curso |
| preco | DECIMAL(10,2) | NOT NULL | Preço em reais |
| duracao | INTEGER | NOT NULL | Duração em horas |
| num_aulas | INTEGER | NOT NULL | Número de aulas |
| descricao | TEXT | NULL | Descrição do curso |
| certificado | BOOLEAN | DEFAULT TRUE | Inclui certificado? |
| avaliacao | DECIMAL(2,1) | DEFAULT 0 | Nota média (0-5) |

#### Tabela: COMPRA
| Atributo | Tipo | Restrições | Descrição |
|----------|------|------------|-----------|
| id | INTEGER | PK, AUTO_INCREMENT | Identificador único |
| id_usuario | INTEGER | FK → USUARIO(id) | Comprador |
| id_item | INTEGER | NOT NULL | ID do instrumento ou curso |
| tipo_item | ENUM('instrumento','curso') | NOT NULL | Tipo do item |
| quantidade | INTEGER | DEFAULT 1 | Quantidade comprada |
| valor_total | DECIMAL(10,2) | NOT NULL | Valor total da compra |
| data_compra | DATETIME | DEFAULT NOW() | Data/hora da compra |
| status | ENUM('pendente','pago','enviado','entregue','cancelado') | DEFAULT 'pendente' | Status |

---

## 🔌 Endpoints da API (Backend)

### Instrumentos
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/instrumentos` | Lista todos os instrumentos |
| GET | `/api/instrumentos/{id}` | Busca instrumento por ID |
| POST | `/api/instrumentos` | Cadastra novo instrumento |

### Cursos
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/cursos` | Lista todos os cursos |
| GET | `/api/cursos/{id}` | Busca curso por ID |
| POST | `/api/cursos` | Cadastra novo curso |

### Usuários
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/api/usuarios/cadastro` | Cadastra novo usuário |
| POST | `/api/usuarios/login` | Realiza login |

### Compras
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/compras/{id_usuario}` | Lista compras do usuário |
| POST | `/api/compras` | Registra nova compra |

---

## 📱 Funcionalidades do MVP

### Implementadas
- ✅ Navegação entre telas (Início, Loja, Cursos)
- ✅ Listagem de instrumentos musicais
- ✅ Listagem de cursos de música
- ✅ Categorias de produtos
- ✅ Cards com informações (preço, avaliação, etc.)
- ✅ Design responsivo e moderno

### Próximas Versões
- 🔲 Tela de login/cadastro
- 🔲 Carrinho de compras
- 🔲 Integração com backend real
- 🔲 Sistema de pagamento
- 🔲 Avaliações de usuários

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos
- Android Studio (versão 2023.1 ou superior)
- JDK 17
- Dispositivo Android ou Emulador (API 24+)

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/Denner67/SoloLivre_mobile
   ```

2. Abra o projeto no Android Studio:
   ```
   File → Open → Selecione a pasta do projeto
   ```

3. Aguarde o Gradle sincronizar as dependências

4. Execute o app:
   - Conecte um dispositivo Android via USB, ou
   - Inicie um emulador
   - Clique em ▶️ (Run)

### Gerar APK
```bash
./gradlew assembleDebug
```
O APK estará em: `app/build/outputs/apk/debug/app-debug.apk`

---

## 👥 Equipe

Denner Ferreira de Morais
Mychell Marques da Silva
---

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos.

