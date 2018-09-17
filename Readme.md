# item
## Introduction
This is a Restful aggregator service which collects product name and price information from different sources and returns output as shown below:

{
    "partNumber": "15117729",
    "title": "The Big Lebowski (Blu-ray)",
    "price": "500.50"
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
| GET  | /v1/product/15117729 | ProductController.getProductDetails | Item name along with the price
| POST | /v1/price/15117729 | ProductController.createPriceById | create/updates price for a given item id
| GET | /v1/price/15117729 | ProductController.getPrice | get price details


## Sample CURL Requests

curl -X POST \
  http://localhost:8080/v1/price/52268280 \
  -H 'content-type: application/json' \
  -d '{
	"price":"22.50",
	"currency":"USD"
}'

curl -X GET \
  http://localhost:8080/v1/product/52268280
