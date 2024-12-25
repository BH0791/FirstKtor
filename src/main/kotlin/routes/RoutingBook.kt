package fr.hamtec.routes

import fr.hamtec.data.Team
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import org.slf4j.LoggerFactory


fun Application.configureRoutingBook(){
    val logger = LoggerFactory.getLogger("Application-Book")
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
        staticResources("/hello", "frontend")

        get("/hello/{user_name}") {
            val userName = call.parameters["user_name"]
            call.respondHtml {
                body {
                    h1 { +"Hello, World!" }
                    p {
                        text("Hello ${userName}")
                        link(rel = "stylesheet", href = "css/styles.css")
                    }

                    ul {
                        repeat(5) {
                            li { +"Item $it" }
                        }
                    }
                    p {
                        id = "intro-paragraph"
                        classes = setOf("intro")
                        style = "color: red; font-size: 20px;"
                        +"This is a demonstration of kotlinx.html."
                    }
                }
            }
        }
        get("/mytemplate") {
            call.respondHtmlTemplate(MyLayoutTemplate(), HttpStatusCode.OK){
                header{
                    p{+"hello kotlin"}
                }
                content{+"Using kotlin to gennerate HTML!"}
            }
        }

    }
}
class MyLayoutTemplate: Template<HTML>{
    val header = Placeholder<FlowContent>()
    val content = Placeholder<FlowContent>()
    override fun HTML.apply() {
        body {
            h1 { insert(header) }
            div {
                p{ insert(content)}
            }
        }
    }

}