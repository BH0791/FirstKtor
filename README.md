## Développement d'API avec Ktor
---
> [Serveur HTTP Netty](https://ktor.io/) <br>
> [gradle-8.12](https://gradle.org/) <br>
> [jdk-23.0.1](https://www.oracle.com/) <br>
> [Kotlin 2.1.00](https://github.com/JetBrains/kotlin/releases) <br>
> [Edge](https://www.microsoft.com/fr-fr/edge/download?form=MA13FJ)<br>
> [Boomerang](https://microsoftedge.microsoft.com/addons/detail/boomerang-soap-rest-c/bhmdjpobkcdcompmlhiigoidknlgghfo)<br>
> [curl://](https://curl.se/)

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