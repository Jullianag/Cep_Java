# CEP JAVA SPRING BOOT

### API VIA CEP
- WebClient

# Sobre o projeto

O projeto CEP Java é uma aplicação back end desenvolvida para treinamento de conceitos como tratamento de exceções, 
spring-webflux, camadas service e controller, controller handlers.
No postman, via requisição GET, coloca-se o número do cep para a resposta exibir:
- cep
- logradouro
- complemento
- bairro
- localidade
- uf

Caso o cep não exista o postman mostra uma mensagem personalizada.

## Postman
![Demonstração 1](https://github.com/Jullianag/Cep_Java/blob/main/src/main/resources/assets/ok.png)

![Demonstração 2](https://github.com/Jullianag/Cep_Java/blob/main/src/main/resources/assets/404.png)

![Demonstração 3](https://github.com/Jullianag/Cep_Java/blob/main/src/main/resources/assets/400.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- Spring WebFlux
- Maven

```bash
# clonar repositório
git clone https://https://github.com/Jullianag/Cep_Java

# executar o projeto
./mvnw spring-boot:run
```

## Back end
Pré-requisitos: Java 21

# Autor

Julliana Gnecco

https://www.linkedin.com/in/julliana-gnecco/
