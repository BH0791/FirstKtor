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
        get("/teams/{team_id}"){
            val teamId: Int? = call.parameters["team_id"]?.toIntOrNull()
            logger.info("Équipe reçue: $teamId")
            if (teamId == null){
                call.respond(HttpStatusCode.BadRequest)
            }else{
                val team = Team(
                    id = teamId,
                    name = "A voir!"
                )
                call.respond(HttpStatusCode.OK, team)
            }
        }

    }
}