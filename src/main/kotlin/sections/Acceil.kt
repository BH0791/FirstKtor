package fr.hamtec.sections

import kotlinx.html.*

fun HTML.mainTemplate(title: String, content: String) {
    head { commonHead(title)
    }
    body {
        headerSectionAcceuil()
        contentSectionAcceuil(content)
        footerSectionAcceuil()
    }
}

fun HEAD.commonHead(titleText: String) {
    title { +titleText }
    link(rel = "stylesheet", href = "/static/css/styleWelcome.css")
}
fun BODY.headerSectionAcceuil() {
    header(classes = "main-header") {
        h1 { +"Bienvenue sur mon site!" }
        nav {
            ul {
                li { a(href = "/") { +"Accueil" } }
                li { a(href = "/about") { +"À propos" } }
                li { a(href = "/contact") { +"Contact" } }
            }
        }
    }
}
fun BODY.contentSectionAcceuil(content: String) {
    main(classes = "content") {
        p { +content }
    }
}
fun BODY.footerSectionAcceuil() {
    footer(classes = "main-footer") {
        p { +"© 2024 Mon Site Web. Tous droits réservés." }
    }
}