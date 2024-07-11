package com.dev.eventify.entities.models

data class Estudiantes(
    val estudiantesId: Int,
    val nickName: String,
    val password: String,
    val imagen: String?,
    val descripcion: String?,
    val tipo: String,
    val nombreFacultad: String
)
data class EstudiantesResponse(
    val estudiantesId: Int,
    val nickName: String,
    val password: String,
    val imagen: String?,
    val descripcion: String?,
    val userType: Int,
    val facultadesId: Int,
)