package fr.hamtec.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory

fun Application.configureRoutingExemple(){
    val logger = LoggerFactory.getLogger("Application-Exemple")
    routing {
        get("/compressed-example") {
            // Ajouter l'en-tête "Content-Encoding: gzip"
            call.response.headers.append("Content-Encoding", "gzip")
            // Répondre avec un message texte
            call.respondText("This is a gzip compressed response", ContentType.Text.Plain)
            //* teste avec: curl -H "Accept-Encoding: gzip" localhost:8080/compressed-example
        }
        get("/example") {
            // Lire l'en-tête "User-Agent"
            val userAgent = call.request.headers["User-Agent"]
            call.respondText("User-Agent: $userAgent")
        }
    }
}