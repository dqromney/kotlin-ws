# kotlin-ws
Web Service using Kotlin and Java and Spring Boot.

**This service was created using IntelliJ 2017.1. There are two services:**

  - A Java Person service invoked by using http://localhost:8081/persons
    - This service creates four random names automatically, and allows you to post, get (/person/{id}), put {/person/{id}), post {/person/{id}) with json body as shown here:
      {
        "id": "5"
        "name": "Bob"
      }

  - A Kotlin Hello world/service/dto invoked by using the following:
    - http://localhost:8081/hello
    - http://localhost:8081/hello-service
    - http://localhost:8081/hello-dto
    
You can either run the mvn spring-boot:run or run the Spring5Application.java, or the KotlinDemoApplication.kt by right-mouse click on either name and select run. 

This is a simple application was created to help me learn and understand how Kotlin works with Spring Boot for my STG CDP. 

That is it. dqr
