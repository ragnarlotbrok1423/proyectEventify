package com.dev.eventify.entities.models

data class Estudiantes(
    var nickname: String,
    var password: String,
    var imagen: String?,
    var descripcion: String?,
    var facultadesId: Int,
)
