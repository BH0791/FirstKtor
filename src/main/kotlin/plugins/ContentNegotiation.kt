package fr.hamtec.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

fun Application.configureContentNegotiation() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint =true               //+Cela rend la sortie JSON plus lisible en ajoutant des retours à la ligne et une indentation.
            isLenient =true                 //+Cela permet une sérialisation et désérialisation plus flexible, en acceptant des entrées qui ne sont pas strictement conformes aux spécifications JSON, comme des noms de champs non guillemets.
            ignoreUnknownKeys = true        //+Ignore les clés inconnues lors de la désérialisation.
            encodeDefaults = true           //+ Encode les valeurs par défaut des propriétés.
            allowStructuredMapKeys = true   //+Permet l'utilisation de clés complexes (structurées) dans les maps.
            useArrayPolymorphism = false    //+Utilise le polymorphisme basé sur des objets plutôt que sur des tableaux.
            classDiscriminator = "type"     //+Spécifie le nom de l'attribut utilisé pour la discrimination de classe dans le polymorphisme.
        })
        //*xml()
    }
}