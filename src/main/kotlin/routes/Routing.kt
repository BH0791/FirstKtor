package fr.hamtec.routes

import fr.hamtec.data.Team
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory

fun Application.configureRouting() {
    val logger = LoggerFactory.getLogger("\nApplication")
    routing {
        get("/teams") {
            //* Page blanche
            call.respond("Hello")
        }
        get("/teams/{team_id}/players/{playe_id}"){
            val teamId: Int? = call.parameters["team_id"]?.toIntOrNull()

            logger.info("Équipe reçue: $teamId")

            if ((teamId ) == null){
                call.respond(HttpStatusCode.BadRequest)
            }else{
                val team = Team(
                    id = teamId,
                    name = "A souli!"
                )
                call.respond(HttpStatusCode.OK, team)
            }
        }
        get("/teams/") {
            val country: String? = call.queryParameters["country"]
            if (country == null){
                call.respond(HttpStatusCode.BadRequest)
            }else{
                call.respond(HttpStatusCode.OK, country)
            }
        }
    }
}