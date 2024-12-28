package fr.hamtec.routes

import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory

fun Application.configureWelcome() {
    val logger = LoggerFactory.getLogger("Application-Book")

    routing {
        staticResources("/static", "static")
        get("/welcome") {
            call.respond(
                FreeMarkerContent(
                    "acceuil/welcome.ftl",
                    mapOf("title" to "Bienvenue", "message" to "Bonjour à tous!")
                ), typeInfo = null
            )
        }
        // Ajout d'une nouvelle page d'accueil
        get("/home") {
            call.respond(
                FreeMarkerContent(
                    "acceuil/home.ftl",
                    mapOf("title" to "Page d'Accueil", "message" to "Bienvenue sur la page d'accueil!")
                ), typeInfo = null
            )
        }
// Ajout d'une page à propos
        get("/about") {
            call.respond(
                FreeMarkerContent(
                    "about/about.ftl",
                    mapOf("title" to "À propos", "message" to "En savoir plus sur nous.")
                ), typeInfo = null
            )
        }
        // Ajout d'une page de contact
        get("/contact") {
            call.respond(
                FreeMarkerContent(
                    "contact/contact.ftl",
                    mapOf("title" to "Contact", "message" to "Contactez-nous ici.")
                ), typeInfo = null
            )
        }
    }
}