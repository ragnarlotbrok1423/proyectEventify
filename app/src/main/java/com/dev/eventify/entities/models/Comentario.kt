package com.dev.eventify.entities.models

data class Comentario(
    val comentarioId: Int = 0,
    val profesorId: Int,
    val materiaId: Int,
    val valoracion: Int,
    val comentario: String,
    val createdAt: String = ""
)
