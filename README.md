# Spring project Dio Santander Week 2023

Projeto desenvolvido para colocar em prática habilidades em projeto em Linguagem Java com Springboot.
A seguir vamos poder ver o diagrama de classes feito com recurso grafico mermaid e ChatGPT, onde informamos as classes em formato json para a IA criar o diagrama em formato Mermaid. Mais informações em: https://mermaid.js.org/

## Diagrama de classes:

``` mermaid
classDiagram
  class User {
    - name: String
    -Account account
    -Feature[] features
    -Card card
    -News[] news
  }

  class Account {
    - number: String
    - agency: String
    - balance: Double
    - limit: Double
  }

  class Feature {
    - icon: String
    - description: String
  }

  class Card {
    - number: String
    - limit: Double
  }

  class News {
    - icon: String
    - description: String
  }

  User "1" *-- "1" Account
  User "1" *-- "N" Feature
  User "1" *-- "1" Card
  User "1" *-- "N" News
```
## Desenvolvimento em etapas
Para melhor entender a evolução desse projeto você pode comparar as diferentes branchs aqui nesse repositório
1. model - [https://github.com/jacquelinesantana/spring-project-dio-santander/tree/model](link)
2. models-melhoradas - [https://github.com/jacquelinesantana/spring-project-dio-santander/tree/models-melhoradas](link)
3. repository - [https://github.com/jacquelinesantana/spring-project-dio-santander/tree/repository](link)
4. configuracao-com-yml - [https://github.com/jacquelinesantana/spring-project-dio-santander/edit/configuracao-com-yml/](link)

## Configurações para conectar com o H2
Para esse projeto em localhost vamos utilizar o banco de dados em memória H2
Para isso criamos um arquivo YML chamado application-dev.yml com a seguinte estrutura de código:

```
server:
  port: 9090
spring:
  datasource:
    url: jdbc:h2:mem:sdw123
    username: sa
    password: sa
  jpa:
    show-sql: true
    open-in-view: false
    hibernate:
      ddl-auto: create # validate | update | create | create-drop
    properties:
      hibernate:
        format_sql: true
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        trace: false
        web-allow-others: false

```

Após implementar o código acima vamos configurar o run configuration para trabalhar com esse application, também excluídos a estrutura anterior de application.
1. menu **run**
2. opção **run configuration**
3. guia **Environment**
4. botão **add**
5. na caixa de new environment variable vamos inserir em nome: SPRING_PROFILES_ACTIVE no value: dev
6. aplicar e executar o projeto
