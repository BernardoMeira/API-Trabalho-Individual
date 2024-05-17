# API-Trabalho-Individual

Endpoints:

# ----------- LIVRO -----------
- GET localhost:8080/livros -- Buscar todos

- GET localhost:8080/livros/{id} -- Buscar por id

- POST localhost:8080/livros -- Adicionar livro
    
Exemplo JSON:
```
{
    "titulo": "Lord of the Errors",
    "informacaoLivro": {
        "sinopse": "Quem controla o Erro controla tudo",
        "numeroPaginas": 1000,
        "categoria": 2
    },
    "informacaoPublicacao": {
        "autor": {
            "id": 2
        },
        "editora": {
            "id": 1
        },
        "dataPublicacao": "2024-05-16"
    }
}
```
- PUT localhost:8080/livros/{id} -- Alterar livro
    
Exemplo JSON:
```
{
    "titulo": "Warjava 40k: The Javascript Heresy",
    "informacaoLivro": {
        "sinopse": "Alguma coisa",
        "numeroPaginas": 40,
        "categoria": 1
    },
    "informacaoPublicacao": {
        "autor": {
            "id": 1
        },
        "editora": {
            "id": 1
        },
        "dataPublicacao": "2024-05-16"
    }
}
```
- DELETE localhost:8080/livros/{id} -- Deletar livro

- GET localhost:8080/livros/autor -- Encontrar livro pelo autor (String nome)
    
# ----------- AUTOR -----------

- GET localhost:8080/autores -- Buscar todos

- POST localhost:8080/autores -- Adicionar um Autor
  
Exemplo JSON:
```
{
    "nome": "Autor1",
    "dataNascimento": "1980-01-10",
    "nacionalidade": "Brasil"
}
```

- POST localhost:8080/autores/lista -- Adicionar lista

Exemplo JSON:  
```
[
    {
        "nome": "Autor1",
        "dataNascimento": "1980-01-10",
        "nacionalidade": "Brasil"
    },
    {
        "nome": "Autor2",
        "dataNascimento": "1980-01-10",
        "nacionalidade": "Alemanha"
    },
    {
        "nome": "Autor3",
        "dataNascimento": "1980-01-10",
        "nacionalidade": "Inglaterra"
    }
]
```
- DELETE localhost:8080/autores/{id} -- Deletar autor
  
- PUT localhost:8080/autores/{id} -- Alterar autor

# ----------- EDITORA -----------

- GET localhost:8080/editoras -- Buscar todos

- POST localhost:8080/editoras -- Adicionar uma editora
  
Exemplo JSON:  
```
{
    "nome": "Belas Artes",
    "localizacao": "Brazil"
}
```
- POST localhost:8080/editoras/lista -- Adicionar lista

Exemplo JSON:  
```
[
    {
        "nome": "Editora1",
        "localizacao": "Alemanha"
    },
    {
        "nome": "Editora2",
        "localizacao": "Inglaterra"
    }
]
```
- DELETE localhost:8080/editoras/{id} -- Deletar editora

- PUT localhost:8080/editoras/{id} -- Alterar editora

Exemplo JSON:
```
{
    "nome": "Belas Erros",
    "localizacao": "Brazil"
}
```
   
