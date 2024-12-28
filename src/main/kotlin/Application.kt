package fr.hamtec

import fr.hamtec.plugins.configureContentNegotiation
import fr.hamtec.plugins.configureFreemarker
import fr.hamtec.plugins.configureRequestValidation
import fr.hamtec.plugins.configureStatusPage
import fr.hamtec.routes.configureRouting
import io.ktor.server.application.*
import io.ktor.server.netty.*

//+ Point d'entrée de l'application
//+ La fonction main de l'application peut simplement appeler la fonction main du moteur HTTP choisi.
fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    configureContentNegotiation()
    configureRequestValidation()
    configureStatusPage()
    configureFreemarker()
    configureRouting()
}