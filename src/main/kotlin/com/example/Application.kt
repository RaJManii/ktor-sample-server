package com.example

import io.ktor.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.session.DrawingSession
import com.google.gson.Gson
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*
import io.ktor.util.*


val server = DrawingServer()
val gson = Gson()

fun main() {
    embeddedServer(Netty, port = 8010, host = "192.168.68.105", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    /*routing {
        get("/plain") {
            call.respondText("Hello World!")
        }
    }*/
    install(Sessions) {
        cookie<DrawingSession>("SESSION")
    }

    // This is used for if client request the session
    intercept(ApplicationCallPipeline.Features) {
        if (call.sessions.get<DrawingSession>() == null) {
            val clientId = call.parameters["client_id"] ?: ""
            call.sessions.set(DrawingSession(clientId, generateNonce()))
        }
    }


    configureSerialization()
    configureSockets()
    configureMonitoring()
    configureRouting()
}
