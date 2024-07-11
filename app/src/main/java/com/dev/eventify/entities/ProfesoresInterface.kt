package com.dev.eventify.entities

interface PostProfesores {
    suspend fun createProfesor (
        nombre: String,
        apellido: String,
        email: String,
        password: String,
        rol:Int,
        imagen: String?,
        descripcion: String?,
    ):String
}