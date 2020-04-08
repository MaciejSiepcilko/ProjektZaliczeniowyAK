# ProjektZaliczeniowyAK


You are required to:
Create a spring boot docker application with Jre8
Application required to download image database https://github.com/ghusta/docker-postgres-world-db during build and connect to it during runtime


Implement an endpoint which when given country code should return country information

Example  GET- http:/localhost:8080/BHR should return:
{

"name": "Bahrain"

"continent": "Asia"

"population":617000

"life_expectancy":73

"country_language":"Arabic"
}

Create Unit Tests for the following tests

if non existent code is called then return error message:"INVALID_COUNTRY_CODE" and http response should be internal server error

if database is down then the error message should be "INTERNAL_ERROR" and http response should be internal server error
 
