# 🚀 Spring Boot Loans

[![SPRING FRAMEWORK](https://img.shields.io/badge/Spring%20framework-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://github.com/BerettaSM/exemplo-readme/blob/main/LICENSE)
[![JAVA](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://github.com/BerettaSM/exemplo-readme/blob/main/LICENSE) 
![GitHub repo size](https://img.shields.io/github/repo-size/BerettaSM/loans?style=for-the-badge)

> O projeto foi desenvolvido como uma solução do desafio do [Backend-br](https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md).

## Descrição

Este projeto implementa um serviço que determina as modalidades de empréstimo às quais um cliente tem acesso, com base em seu perfil, incluindo idade, salário e localização. O serviço está implementado utilizando os princípios da **Clean Architecture**, o padrão **Specification** para regras de negócio, e adotando a abordagem **TDD** para garantir a qualidade do código.

## Principais Features

* **Modalidades de Empréstimo**:

  * Empréstimo pessoal (taxa de 4% de juros).
  * Empréstimo consignado (taxa de 2% de juros).
  * Empréstimo com garantia (taxa de 3% de juros).

* **Validação de Regras**: O acesso a cada modalidade de empréstimo depende de uma combinação de variáveis:

  * **Salário**: O valor do salário do cliente determina qual empréstimo ele pode acessar.
  * **Idade**: Se o cliente tem mais de 30 anos, isso pode influenciar a elegibilidade para certos tipos de empréstimo.
  * **Localização**: O estado do cliente pode ser relevante para algumas modalidades de empréstimo, especialmente para quem reside em São Paulo (SP).

* **Padrão Clean Architecture**: O código foi estruturado para garantir uma alta coesão, baixo acoplamento e fácil manutenção, separando as responsabilidades em diferentes camadas, como `core`, `application` e`infrastructure`.

* **Design Pattern Specification**: Utilizado para modelar as regras de negócio de uma maneira flexível, permitindo a fácil combinação de condições (e.g., idade, salário, localização) para determinar se um cliente é elegível para um empréstimo.

* **TDD (Test-Driven Development)**: Todas as classes de regras de empréstimo e as especificações foram testadas utilizando TDD, garantindo que a lógica de negócio funcione corretamente.

## Estrutura do Projeto

A estrutura do projeto segue o padrão Clean Architecture, com as seguintes camadas:

* **Core**: Contém as entidades de domínio (como `Customer`, `Loan`), regras de negócio e especificações.
* **Application**: Contém os casos de uso e lógica de aplicação (como `AssessLoansUseCase`).
* **Infrastructure/Web**: Contém as implementações de infraestrutura, como a configuração de beans, validação, controllers, mapeamento de DTOs e endpoints REST.

## Endpoints

### Endpoint de Avaliação de Empréstimos

* **POST** `/customer-loans`

  Este endpoint recebe as informações de um cliente e retorna as modalidades de empréstimo às quais ele tem acesso com base nas regras de negócio estabelecidas.

#### Request Body

O corpo da requisição deve ser enviado no formato JSON e deve conter os seguintes campos:

```json
{
    "age": 26,
    "cpf": "275.484.389-23",
    "name": "Vuxaywua Zukiagou",
    "income": 7000.00,
    "location": "SP"
}
```

* `age`: A idade do cliente (número inteiro).
* `cpf`: O CPF do cliente (formato: `XXX.XXX.XXX-XX`, precisa ser válido).
* `name`: O nome do cliente (mínimo 4 caracteres).
* `income`: O salário do cliente (valor numérico).
* `location`: A localização do cliente (deve ser um estado válido, como "SP", "RJ", etc.).

#### Exemplo de requisição usando `curl`

```bash
curl -X POST http://localhost:8080/customer-loans \
     -H "Content-Type: application/json" \
     -d '{
           "age": 26,
           "cpf": "275.484.389-23",
           "name": "Vuxaywua Zukiagou",
           "income": 7000.00,
           "location": "SP"
         }'
```

#### Resposta Esperada

Se a requisição for bem-sucedida (HTTP 200 OK), a resposta será um JSON contendo o nome do cliente e uma lista das modalidades de empréstimo disponíveis:

```json
{
    "customer": "Vuxaywua Zukiagou",
    "loans": [
        {
            "type": "PERSONAL",
            "interest_rate": 4
        },
        {
            "type": "GUARANTEED",
            "interest_rate": 3
        },
        {
            "type": "CONSIGNMENT",
            "interest_rate": 2
        }
    ]
}
```

### Códigos de Resposta HTTP

* **200 OK**: Requisição bem-sucedida e resposta gerada com as modalidades de empréstimo disponíveis para o cliente.

* **422 Unprocessable Entity**: Se a validação falhar (por exemplo, se o CPF for inválido ou se faltar algum campo obrigatório), o serviço retornará um erro 422 com detalhes sobre o problema:

```json
{
    "message": "Validation error(s)",
    "status": 422,
    "timestamp": "2025-11-12T23:30:54.992833997Z",
    "path": "/customer-loans",
    "errors":[
        {
            "fieldName": "location",
            "messages": [
                "Location is required",
                "Location must be a valid state"
            ]
        },
        {
            "fieldName": "cpf",
            "messages": [
                "Must be a valid CPF"
            ]
        }
    ]
}
```

## Como Rodar o Projeto

Este projeto foi desenvolvido com Java e Spring Boot. Para rodá-lo localmente, siga os passos abaixo:

### Pré-requisitos

* Java 21 ou superior
* Maven

### Rodando Localmente

1. **Clone o repositório:**

```bash
git clone https://github.com/BerettaSM/loans
cd loans
```

2. **Compile o projeto com Maven:**

```bash
./mvnw clean install
```

3. **Rode o aplicativo:**

```bash
./mvnw -pl infrastructure/web spring-boot:run
```

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

## Testes

Os testes foram escritos com o framework JUnit e seguem a abordagem **TDD**. Os testes mais críticos estão localizados na camada `coretest`, com foco nas regras de negócio e especificações de elegibilidade dos empréstimos.

Para rodar os testes:

```bash
./mvnw -pl coretest,application test
```

## 📄 Licença

Este projeto é licenciado sob os termos da [MIT License](LICENSE).