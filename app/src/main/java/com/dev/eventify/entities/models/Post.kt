package com.dev.eventify.entities.models

data class Post(
    var comentario: String,
    var titulo: String,
    var imagen: String,
    val groupId: Int? = null  // Añadir un campo opcional para el grupo
)
