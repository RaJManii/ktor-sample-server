package com.example.plugins

import com.example.routes.createRoomRoute
import com.example.routes.gameWebSocketRoute
import com.example.routes.getRoomsRoute
import com.example.routes.joinRoomRoute
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    routing {
        /*get("/") {
            call.respondText("Hello World!")
        }*/
        createRoomRoute()
        getRoomsRoute()
        joinRoomRoute()
        gameWebSocketRoute()
    }
}
