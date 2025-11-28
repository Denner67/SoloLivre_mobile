# SoloLivre - App Android

Aplicativo Android para venda de instrumentos musicais e cursos online.

## 📱 Sobre o Projeto

O **SoloLivre** é um aplicativo desenvolvido para facilitar a venda de instrumentos musicais e oferecer cursos online de música. O app apresenta uma interface moderna e intuitiva, seguindo as cores e design especificados.

### Características

- ✅ Interface responsiva e moderna
- ✅ Paleta de cores personalizada (verde-petróleo, laranja, bege)
- ✅ Lista de cursos disponíveis com informações detalhadas
- ✅ Card destacado para curso mais popular
- ✅ Avaliações, número de alunos e duração dos cursos
- ✅ Indicador de certificação
- ✅ Níveis de dificuldade (Iniciante, Intermediário, Avançado)

## 🎨 Design

O aplicativo segue a identidade visual fornecida:
- **Cor primária**: Verde-petróleo (#1A5F5F)
- **Cor de destaque**: Laranja (#FF6B1A)
- **Fundo**: Bege claro (#FFF8F0)
- **Logo**: SoloLivre em azul-verde (#4A9B9B)

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java
- **SDK mínimo**: Android 7.0 (API 24)
- **SDK alvo**: Android 14 (API 34)
- **Bibliotecas**:
  - AndroidX AppCompat
  - Material Design Components
  - RecyclerView
  - CardView
  - ConstraintLayout

## 📦 Como Compilar

### Pré-requisitos

- Android Studio Arctic Fox ou superior
- JDK 11 ou superior
- Android SDK com API 34

### Passos para Compilar

1. **Abra o Android Studio**

2. **Importe o projeto**
   - File → Open
   - Selecione a pasta `SoloLivre`

3. **Aguarde a sincronização do Gradle**
   - O Android Studio irá baixar automaticamente as dependências

4. **Execute o projeto**
   - Conecte um dispositivo Android ou inicie um emulador
   - Clique no botão "Run" (▶️) ou pressione Shift+F10

5. **Gerar APK**
   - Build → Build Bundle(s) / APK(s) → Build APK(s)
   - O APK será gerado em: `app/build/outputs/apk/debug/app-debug.apk`

## 📱 Funcionalidades Implementadas

### Tela Principal

- **Header**: Logo SoloLivre e ícone de perfil
- **Seção de Cursos**: Título e descrição
- **Card Destacado**: Curso mais popular com badge especial
- **Lista de Cursos**: RecyclerView com cards de cursos

### Informações dos Cursos

Cada curso exibe:
- Imagem ilustrativa
- Nome do curso
- Professor responsável
- Avaliação (estrelas)
- Número de alunos
- Duração em horas
- Preço
- Nível de dificuldade
- Status de certificação

## 🎓 Cursos de Exemplo

O app vem com 4 cursos pré-cadastrados:

1. **Curso Completo de Violão** (Destaque)
   - Prof. Carlos Silva
   - 4.9 ⭐ | 1.2k alunos | 12h
   - R$ 299

2. **Violão do Zero ao Avançado**
   - Prof. Carlos Silva
   - 4.9 ⭐ | 1243 alunos | 12 horas
   - R$ 299 | Iniciante

3. **Piano Clássico - Fundamentos**
   - Profa. Ana Martins
   - 4.8 ⭐ | 892 alunos | 15 horas
   - R$ 349 | Iniciante

4. **Guitarra Rock - Técnicas Essenciais**
   - Prof. Bruno Costa
   - 4.7 ⭐ | 654 alunos | 10 horas
   - R$ 279 | Intermediário

5. **Bateria para Iniciantes**
   - Prof. Ricardo Santos
   - 4.6 ⭐ | 423 alunos | 8 horas
   - R$ 249 | Iniciante

## 📂 Estrutura do Projeto

```
SoloLivre/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/sololivre/app/
│   │       │   ├── MainActivity.java
│   │       │   ├── Course.java
│   │       │   └── CourseAdapter.java
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   ├── activity_main.xml
│   │       │   │   └── course_item.xml
│   │       │   ├── values/
│   │       │   │   ├── colors.xml
│   │       │   │   ├── strings.xml
│   │       │   │   └── styles.xml
│   │       │   ├── drawable/
│   │       │   │   ├── ic_user.xml
│   │       │   │   ├── ic_trophy.xml
│   │       │   │   ├── circle_background.xml
│   │       │   │   ├── badge_background.xml
│   │       │   │   └── rounded_corner.xml
│   │       │   └── mipmap-*/
│   │       │       ├── ic_launcher.png
│   │       │       └── ic_launcher_round.png
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── gradle.properties
```

## 🚀 Próximos Passos (Sugestões)

Para expandir o projeto, você pode adicionar:

- [ ] Tela de detalhes do curso
- [ ] Sistema de login e cadastro
- [ ] Carrinho de compras
- [ ] Integração com gateway de pagamento
- [ ] Player de vídeo para aulas
- [ ] Sistema de favoritos
- [ ] Filtros e busca de cursos
- [ ] Perfil do usuário
- [ ] Histórico de compras
- [ ] Sistema de avaliações

## 📄 Licença

Projeto desenvolvido para fins acadêmicos.

## 👨‍💻 Autor

Desenvolvido como trabalho de faculdade.

---

**Nota**: Este é um projeto educacional. Para uso em produção, implemente validações de segurança, autenticação adequada e integração com APIs reais.
