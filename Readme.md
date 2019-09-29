# item
## Introduction
This is a Restful aggregator service which collects product name and price information from different sources and returns output as shown below:

{
    "part_number": "76198491",
    "title": "Samsung 55\" Smart 4K UHD TV - Charcoal Black (UN55RU7100FXZA)",
    "current_price": {
	"value": "499.99",
	"currency": "USD"
     }
}

## Technology Stack
* Java 8
* SpringBoot
* SpringDataCassandra
* Gradle
* RxJava

## Dependency
### Apache cassandra
It requires the database up and running at node mentioned in cassandra.properties. In this example it uses local instance.
To run in local create the below keyspace, table info and provide cassandra host, port and keyspace info as part of application.properties

create KEYSPACE product WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

create table price (id text, price text, currency text, PRIMARY KEY (id));

sample insert statement: INSERT INTO price (id, price, currency) values ('52268280','30.00', 'USD');

## Running app

gradle bootRun

## Routes

[list all routes that this service supports]

| Method | Route | Class | Description
| ------ | ----- | ----- | -----------
| GET  | /v1/product/76198491 | ProductController.getProductDetails | Item name along with the price
| POST | /v1/price | ProductController.createPriceById | create/updates price for a given item id
| PUT | /v1/price/76198491 | ProductController.updatePriceById | update price details

## Swagger spec for service definitions/contracts

http://localhost:8082/swagger-ui.html

## Sample CURL Requests

curl -X POST \
  http://localhost:8082/v1/price \
  -H 'content-type: application/json' \
  -d '{
  	"id": "76198491",
	"price":"499.99",
	"currency":"USD"
}'

curl -X GET \
  http://localhost:8082/v1/product/76198491
  
curl -X PUT \
  http://localhost:8082/v1/price/76198491 \
  -H 'content-type: application/json' \
  -d '{
	"price":"449.99"
}'
