package com.example.data.models

import com.example.other.Constants.TYPE_DRAE_ACTION

data class DrawAction(
    val action: String
) : BaseModel(TYPE_DRAE_ACTION) {
    companion object {
        const val ACTION_UNDO = "ACTION_UNDO"
    }
}