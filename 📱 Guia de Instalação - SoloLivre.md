# 📱 Guia de Instalação - SoloLivre

## Método 1: Baixar a aplicação presente no repositório, segue o link -> https://github.com/Denner67/SoloLivre_mobile/blob/main/SoloLivre.apk

## Método 2: Importar no Android Studio (Recomendado)

### Passo 1: Instalar o Android Studio

1. Baixe o Android Studio em: https://developer.android.com/studio
2. Instale seguindo as instruções do instalador
3. Na primeira execução, instale os componentes recomendados (SDK, emulador, etc.)

### Passo 2: Importar o Projeto

1. Abra o Android Studio
2. Clique em **File → Open**
3. Navegue até a pasta `SoloLivre` e selecione-a
4. Clique em **OK**

### Passo 3: Sincronizar Dependências

1. O Android Studio irá detectar o projeto Gradle
2. Aguarde a sincronização automática (pode levar alguns minutos na primeira vez)
3. Se aparecer algum erro, clique em **File → Sync Project with Gradle Files**

### Passo 4: Executar o App

**Opção A: Usar Emulador**
1. Clique no ícone **Device Manager** (ícone de celular)
2. Crie um novo dispositivo virtual (Virtual Device)
3. Selecione um modelo (ex: Pixel 6)
4. Escolha uma imagem do sistema (recomendado: API 34 - Android 14)
5. Clique em **Finish**
6. Clique no botão **Run** (▶️) ou pressione **Shift+F10**

**Opção B: Usar Dispositivo Físico**
1. Ative o **Modo Desenvolvedor** no seu Android:
   - Vá em Configurações → Sobre o telefone
   - Toque 7 vezes em "Número da versão"
2. Ative a **Depuração USB**:
   - Configurações → Opções do desenvolvedor → Depuração USB
3. Conecte o celular ao computador via USB
4. Autorize a depuração quando solicitado
5. Selecione seu dispositivo na barra superior do Android Studio
6. Clique no botão **Run** (▶️)

### Passo 5: Gerar APK para Instalação

1. No Android Studio, vá em **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. Aguarde a compilação
3. Quando concluído, clique em **locate** na notificação
4. O APK estará em: `app/build/outputs/apk/debug/app-debug.apk`
5. Transfira o APK para seu celular e instale

---

## Método 3: Compilar via Linha de Comando

### Pré-requisitos

- JDK 11 ou superior instalado
- Android SDK instalado
- Variável de ambiente `ANDROID_HOME` configurada

### Comandos

```bash
# Navegar até a pasta do projeto
cd SoloLivre

# Dar permissão de execução ao gradlew (Linux/Mac)
chmod +x gradlew

# Compilar o projeto
./gradlew assembleDebug

# O APK será gerado em:
# app/build/outputs/apk/debug/app-debug.apk
```

**No Windows:**
```cmd
cd SoloLivre
gradlew.bat assembleDebug
```

---

## Solução de Problemas

### Erro: "SDK not found"

1. Abra o Android Studio
2. Vá em **File → Project Structure → SDK Location**
3. Configure o caminho do Android SDK
4. Clique em **Apply** e **OK**

### Erro: "Gradle sync failed"

1. Verifique sua conexão com a internet
2. Clique em **File → Invalidate Caches / Restart**
3. Tente sincronizar novamente

### Erro: "Minimum SDK version"

1. Certifique-se de que seu dispositivo/emulador tem Android 7.0 (API 24) ou superior
2. Para usar em versões anteriores, edite `app/build.gradle` e altere `minSdk`

### App não instala no celular

1. Verifique se a instalação de apps de fontes desconhecidas está ativada:
   - Configurações → Segurança → Fontes desconhecidas (ou Apps desconhecidos)
2. Certifique-se de que o APK foi transferido completamente

---

## Requisitos do Sistema

### Para Desenvolvimento (Android Studio)

- **Sistema Operacional**: Windows 10/11, macOS 10.14+, ou Linux
- **RAM**: Mínimo 8GB (recomendado 16GB)
- **Espaço em Disco**: 10GB livres
- **Processador**: Intel i5 ou equivalente

### Para Executar o App

- **Android**: Versão 7.0 (Nougat) ou superior (API 24+)
- **Espaço**: ~20MB

---

## Recursos Adicionais

- **Documentação Android**: https://developer.android.com/docs
- **Tutoriais Android Studio**: https://developer.android.com/studio/intro
- **Comunidade**: Stack Overflow, Reddit r/androiddev

---

## Suporte

Para dúvidas sobre o projeto, consulte o arquivo `README.md` ou entre em contato com o desenvolvedor.

**Bom desenvolvimento! 🚀**
