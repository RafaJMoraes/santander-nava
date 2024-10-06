
# Calculadora de Frete

Esse projeto tempo por obetivo abstrair a ideia de cálculo de frete, nesse sentido irá abordar alguns tipos de cálculo, tais como:
* **Cubagem**
  - Quando a densidade é baixa mas o volume é alto
* **Peso**
  - Quando o peso é muito alto
* **Risco**
  - Quando o valor da mercadoria é alto

##Considerações para a Aplicação
A levará em conta os seguintes pontos:
1. Transporte terrestre.
2. Capacidade de 300 kg/m³.
3. Validação de CEP através da integração com a API do viaCEP: [ViaCep](https://viacep.com.br/).
4. Cáculo da rota utilizando a integração com o Google Maps (Api Distance Matrix): [Google Maps Distance Matrix](https://developers.google.com/maps/documentation/distance-matrix/start?hl=pt-br#maps_http_distancematrix_start-txt)

### Desenho da Arquitetura
![Arquitetura do Projeto](readme/arch.png)

### Composição da Arquitetura

A aplicação está composta por uma Api feita em Java 21, uma banco de dados relacional PostgresSql e WireMock. Para tanto está foi utilizado o docker para do banco de dados bem como o Wiremock, além de uma container para a aplicação.



