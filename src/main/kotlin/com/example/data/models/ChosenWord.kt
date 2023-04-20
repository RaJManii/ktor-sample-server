package com.example.data.models

import com.example.other.Constants.TYPE_CHOSEN_WORLD

data class ChosenWord(
    val chosenWord: String,
    val roomName: String
) : BaseModel(TYPE_CHOSEN_WORLD)
