package com.dev.eventify.entities.models

data class Profesores(
    val profesoresId: Int,
    val nombre: String,
    val apellido: String,
    val email: String,
    val password: String,
    val UserTypeId: String,
    val imagen: String,
    val descripcion: String
)
data class ProfesoresResponse(
    val profesoresId: Int,
    val nombre: String,
    val apellido: String,
    val email: String,
    val password: String,
    val UserTypeId: Int,
     val imagen: String?,
    val descripcion: String?
)
