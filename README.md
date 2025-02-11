# Teste Prático de Programação - Java

---

## Descrição

Este projeto é a solução para um teste prático de programação em Java, onde foram implementadas funcionalidades para gerenciar uma lista de funcionários de uma indústria, realizando diversas operações como:

- Cadastro e manipulação de dados dos funcionários.
- Remoção de um funcionário específico.
- Impressão dos dados formatados corretamente.
- Atualização de salários com aumento percentual.
- Agrupamento de funcionários por função.
- Filtragem de aniversariantes dos meses 10 e 12.
- Identificação do funcionário mais velho.
- Ordenação dos funcionários por nome.
- Cálculo do total de salários.
- Cálculo da quantidade de salários mínimos que cada funcionário recebe.

---

## Tecnologias Utilizadas

Java 17+

---

# Estrutura do Projeto

```
.
├── README.md
├── iniflix-challenge
│   ├── iniflix-challenge.iml
│   ├── out
│   │   └── production
│   │       └── iniflix-challenge
│   │           ├── core
│   │           │   ├── domain
│   │           │   │   ├── Funcionario$FuncionarioBuilder.class
│   │           │   │   ├── Funcionario.class
│   │           │   │   └── Pessoa.class
│   │           │   └── usecase
│   │           │       ├── AgruparFuncionariosPorFuncaoUseCase.class
│   │           │       ├── AumentoSalarialUseCase.class
│   │           │       ├── ObterAniversariantesPorMesUseCase.class
│   │           │       ├── ObterFuncionarioMaisVelhoUseCase.class
│   │           │       ├── ObterQuantidadeSalariosPorFuncionarioUseCase.class
│   │           │       ├── ObterTotalSalariosUseCase.class
│   │           │       └── OrdenaPorOrdemAlfabeticaUseCase.class
│   │           ├── dataprovider
│   │           │   └── FuncionarioRepository.class
│   │           ├── main
│   │           │   └── Main.class
│   │           └── utils
│   │               └── Formatador.class
│   └── src
│       ├── core
│       │   ├── domain
│       │   │   ├── Funcionario.java
│       │   │   └── Pessoa.java
│       │   └── usecase
│       │       ├── AgruparFuncionariosPorFuncaoUseCase.java
│       │       ├── AumentoSalarialUseCase.java
│       │       ├── ObterAniversariantesPorMesUseCase.java
│       │       ├── ObterFuncionarioMaisVelhoUseCase.java
│       │       ├── ObterQuantidadeSalariosPorFuncionarioUseCase.java
│       │       ├── ObterTotalSalariosUseCase.java
│       │       └── OrdenaPorOrdemAlfabeticaUseCase.java
│       ├── dataprovider
│       │   └── FuncionarioRepository.java
│       ├── main
│       │   └── Main.java
│       └── utils
│           └── Formatador.java
```

O projeto segue uma estrutura que seria semelhante a uma **Clean Architecture** porém sem reais desacoplamentos, pois seria *overengineering*

---

# Como Executar

Clone o repositório:
```
git clone git@github.com:pdroacordi/iniflix-practical-challenge.git
```
Acesse a pasta do projeto:
```
cd iniflix-challenge
```
Compile e execute:
```
for /r %i in (*.java) do javac -d out/production/iniflix-challenge -sourcepath src %i

java -cp out/production/iniflix-challenge main.Main
```

---

## Funcionalidades Implementadas

✅ Cadastro de funcionários

✅ Impressão de dados formatados

✅ Remoção de um funcionário

✅ Atualização de salários com aumento de 10%

✅ Agrupamento por função

✅ Filtro de aniversariantes

✅ Identificação do mais velho

✅ Ordenação por nome

✅ Cálculo do total de salários

✅ Cálculo de quantidade de salários mínimos

---

## Autor

**Pedro Acordi** - [LinkedIn](https://www.linkedin.com/in/paacordi/)