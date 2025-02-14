# Digrama de Classe

```mermaid
classDiagram
    class User {
        -String name
        -Account account
        -List~Feature~ feature
        -Card card
        -List~News~ news
    }

    class Account {
        -String number
        -String agency
        -double balance
        -double limit
    }

    class Feature {
        -String icon
        -String description
    }

    class Card {
        -String number
        -double limit
    }

    class News {
        -String icon
        -String description
    }

    User "1" *--> "1" Account
    User "1" *--> "N" Feature : has multiple
    User "1" *--> "1" Card
    User "1" *--> "N" News : has multiple
```
---

