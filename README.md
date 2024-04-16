# Java AI Powered

# Projeto do Bootcamp DIO Java AI Powered - Challenge Railway

## Diagrama de classes

```mermaid
  classDiagram
    class Usuario{
      -String usuario
      -Pessoa pessoa
      -String email
    }

    class Pessoa{
      -String cpf
      -String nome
      -Date dataNascimento
    }

    class Curso{
      -String nome
      -String sigla
    }

    class Matricula{
      -String matricula
      -Curso curso
      -Usuario usuario
    }

    Usuario "1" *-- "1" Pessoa
    Matricula "1" *-- "1" Curso
    Matricula "1" *-- "1" Usuario
```
