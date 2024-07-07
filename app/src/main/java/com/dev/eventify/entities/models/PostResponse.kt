package com.dev.eventify.entities.models

data class PostResponse(
    var PostId: Int,
    var comentario: String,
    var titulo: String,
    var imagen: String,
    var state:Boolean=true
)
