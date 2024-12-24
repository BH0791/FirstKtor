package fr.hamtec.routes

import fr.hamtec.data.Team
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory
import io.ktor.server.application.*


fun Application.configureRoutingBook(){
    val logger = LoggerFactory.getLogger("Application")
    routing {
        //staticFiles("/static", File("resources"))
        staticResources("/website", "frontend")
        get("/teamsv1") {
            //* Page blanche
            call.respond("Hello")
        }
        get("/teams/{team_id}") {
            val teamId: Int? = call.parameters["team_id"]?.toIntOrNull()

            logger.info("Équipe reçue: $teamId")

            if ((teamId) == null) {
                call.respond(HttpStatusCode.BadRequest)
            } else {
                val team = Team(
                    id = teamId,
                    name = "A souli!"
                )
                call.respond(HttpStatusCode.OK, team)
            }
        }
        post("/teams") {
            val team = call.receive<Team>()
            call.respond(HttpStatusCode.OK, team)
        }
        get("/teams/{team.id}") {
            val teamId: Int? = call.parameters["team.id"]?.toIntOrNull()
            if (teamId == null) {
                call.respond(HttpStatusCode.BadRequest)
            } else {
                val team = Team(
                    id = teamId,
                    name = "France"
                )
                call.respond(HttpStatusCode.OK, team)
            }
        }
        get("/teams2/{id}") {
            val teamId = call.parameters["id"]
            val team = Team(id = teamId?.toIntOrNull() ?: 0, name = "Souli!")
            call.respond(team)
        }
        get("/example") {
            // Lire l'en-tête "User-Agent"
            val userAgent = call.request.headers["User-Agent"]
            call.respondText("User-Agent: $userAgent")
        }

    }
}