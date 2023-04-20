package com.example.data.models

data class PlayerData(
    val userName: String,
    val isDrawing: Boolean = false,
    val score: Int = 0,
    var rank: Int = 0
)
