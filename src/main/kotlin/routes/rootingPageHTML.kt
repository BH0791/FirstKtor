package fr.hamtec.routes

import fr.hamtec.sections.commonHead
import fr.hamtec.sections.contentSection
import fr.hamtec.sections.footerSection
import fr.hamtec.sections.headerSection
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.head
import org.slf4j.LoggerFactory

fun Application.configurePageHTML(){
    routing {
        val logger = LoggerFactory.getLogger("Application-Book")
        staticResources("/static", "frontend")
        get("/welcome") {
            logger.info("Request received for /welcome")
            call.respondHtml {
                head{ commonHead() }
                body {
                    headerSection()
                    contentSection("Mettre un texte")
                    footerSection()
                }
            }
            logger.info("Response sent for /welcome")
        }
    }
}