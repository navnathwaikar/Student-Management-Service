#Spring - Student Management Service


This Application can be used to create/view/update/delete Student Records
Also Fetching the Fee Receipt from "Fee Management Service" using Feign Rest Client

Requirements : Maven, jdk 17

Running any service : mvn spring-boot:run

Service Description :
creates students, collects fees and stores the receipt.
Added appropriate validation wherever needed.
Implemented using feign client, circuit breaker, global exceptions, spring jpa

DB used : H2 (In memory database)

Requests: Sample requests for each service available in postman collection file,
please Import file in Postman : "Student Managment Service.postman_collection.json"

Swagger Api Doc : http://localhost:9001/v3/api-docs.yaml
