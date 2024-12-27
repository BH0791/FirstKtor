package fr.hamtec.sections

import kotlinx.html.*

fun HEAD.commonHead(){
    title{+"Home"}
    link(rel = "stylesheet", href = "/static/css/styleWelcome.css")
}
fun BODY.headerSection() {
    header(classes = "title") {
        h1 { +"Bienvenue sur ma page web!" }
    }
}

fun BODY.contentSection() {
    main(classes = "content") {
        p { +"Ceci est le contenu principal de la page généré avec le DSL HTML de Ktor." }
    }
}

fun BODY.footerSection() {
    footer(classes = "container") {
        p { +"Pied de page" }
    }
}