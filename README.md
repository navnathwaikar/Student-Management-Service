#Spring - Student fee management


This project includes implementation of creating viewing Student Details

Requirements : Maven, jdk 17

Running any service : mvn spring-boot:run

Service Description :

student - creates students, collects fees and stores the receipt. Added appropriate validation wherever needed. Implemented using feign client, circuit breaker, global exceptions, spring jpa and in memory H2 database

Requests: Sample requests for each service available in postman collection file,
please import file : "Student Managment Service.postman_collection.json"

Swagger Api Doc : http://localhost:9001/v3/api-docs.yaml
