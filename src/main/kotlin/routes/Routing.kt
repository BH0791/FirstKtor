package fr.hamtec.routes

import io.ktor.server.application.*

fun Application.configureRouting() {
    //* Choisir application a executer
    configureRoutingBook()
    //configureRoutingExemple()
}

