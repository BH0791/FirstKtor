## Développement d'API avec Ktor
---
> Serveur HTTP Netty <br>
> gradle-8.12 <br>
> jdk-23.0.1 <br>
> Kotlin 2.1.00

Bien structurer son application depuis le début.
````kotlin
src
|-main
|   |-kotlin
|   |   |-data
|   |   |-plugins
|   |   |   |-ContentNegotiation.kt
|   |   |-routes
|   |   |   |-Routing.kt
|   |   |-Application.kt
|   |   
|   |-ressource
|       |-application.conf
|       |-logback.xml
|   
|-test

````