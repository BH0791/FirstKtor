package fr.hamtec.plugins

import freemarker.cache.FileTemplateLoader
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import java.io.File

fun Application.configureFreemarker(){
    install(FreeMarker){
        templateLoader = FileTemplateLoader(File("src/main/resources/templates"))
    }
}