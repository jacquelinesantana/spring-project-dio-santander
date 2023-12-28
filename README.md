# Spring project Dio Santander Week 2023
Projeto desenvolvido para colocar em prática habilidades em projeto em Linguagem Java com Springboot.
A seguir vamos poder ver o diagrama de classes feito com recurso grafico mermaid e ChatGPT. Mais informações em: https://mermaid.js.org/


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
