package fr.hamtec.routes

import fr.hamtec.sections.mainTemplate
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory

fun Application.configurePageAcceuil(){
    val logger = LoggerFactory.getLogger("Application-Book")
    routing {
        staticResources("/static", "frontend")
        get("/Acceuil") {
            call.respondHtml {
                mainTemplate("Accueil", "Bienvenue sur ma page d'accueil! Hamtec.com")
            }
        }
    }
}