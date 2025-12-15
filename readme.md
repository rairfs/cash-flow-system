# Cash Flow System GUI

Aplicação Java modular com JavaFX para gerenciamento e visualização de operações financeiras do cliente.

## Tecnologias
- Java 11+ (recomendado Java 17+)
- Maven
- JavaFX
- Projeto modular (arquivo `module-info.java`)

## Requisitos
- JDK instalado
- Maven instalado
- JavaFX SDK ou dependência via Maven (configurar conforme sua plataforma)
- IDE: `IntelliJ IDEA 2025.2.5` (opcional)

## Como buildar
No terminal do projeto:
```bash
  mvn clean package
```

## Como executar
Pelo IDE:
- Configure uma *Run Configuration* apontando para a classe principal (por exemplo `Main` ou `App`).
- Adicione as opções de VM necessárias para JavaFX conforme seu SDK/plataforma.

Pela linha de comando (se estiver configurado o plugin JavaFX no `pom.xml`):
```bash
  mvn javafx:run
```

## Testes
Rodar testes:
```bash
  mvn test
```

## Estrutura importante
- Controladores FXML: `src/main/java/com.ufs.cash_flow_system_gui/controllers`
- Modelos: `src/main/java/com.ufs.cash_flow_system_gui/models`
- Serviços: `src/main/java/com.ufs.cash_flow_system_gui/services`
- `module-info.java`: `src/main/java/module-info.java`

## Problemas comuns e soluções rápidas

- Classe não exportada / erro de reflexão do FXMLLoader  
  Mensagem: `Class 'Report' is not exported from module ...`  
  Solução: abrir o pacote no `module-info.java` para permitir acesso reflexivo do `javafx.fxml`. Exemplo:
  ```java
  module com.ufs.cash_flow_system_gui {
      requires javafx.controls;
      requires javafx.fxml;

      // exports para API pública entre módulos
      exports com.ufs.cash_flow_system_gui;
      exports com.ufs.cash_flow_system_gui.controllers;
      exports com.ufs.cash_flow_system_gui.models;

      // opens para permitir que o FXMLLoader crie/acesse via reflexão
      opens com.ufs.cash_flow_system_gui to javafx.fxml;
      opens com.ufs.cash_flow_system_gui.controllers to javafx.fxml;
      opens com.ufs.cash_flow_system_gui.models to javafx.fxml;
  }
  ```

- Dependência cíclica  
  Mensagem: `Cyclic dependency: com.ufs.cash_flow_system_gui`  
  Causa: declarar `requires com.ufs.cash_flow_system_gui;` no próprio `module-info.java`.  
  Solução: remova essa linha — um módulo não deve requerer a si mesmo.

- Atualizar `userInfo` Label (FXML)  
  Causa comum: acessar campos `@FXML` no construtor do controlador (a injeção ainda não ocorreu).  
  Solução: atualizar a UI no método `@FXML public void initialize()` ou implementando `Initializable`. Para operações custosas, execute em background e atualize a UI com `Platform.runLater(...)`.

## Dicas
- Reconstrua o projeto após alterar `module-info.java`: `mvn clean package`.
- Verifique se os nomes de módulos no `pom.xml` condizem com `module-info.java`.
- Use o debugger do IntelliJ para inspecionar injeção FXML quando um campo marcado com `@FXML` estiver `null`.

## Contato e contribuição
Repositório usa Maven; abra issues e pull requests conforme necessário. Consulte os logs do Maven/IDE para mensagens detalhadas de erro.
```