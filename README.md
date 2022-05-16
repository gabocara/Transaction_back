# Transaction_back
Java Code Challenge

commands to initialize docker

prerequisites
mvn clean install

docker build -t challenge .
docker run -d -p 8080:8080 challenge

swagger url
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/