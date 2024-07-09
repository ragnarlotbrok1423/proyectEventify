package com.dev.eventify.entities

import com.dev.eventify.entities.models.Estudiantes
import com.dev.eventify.entities.models.GruposXpostXestudiantes

interface EstudiantesInterface {
    suspend fun createEstudiantes(nickname: String, password: String, imagen: String, descripcion: String, facultadesId: Int): Estudiantes?
    suspend fun postEstudiantes(estudiantesId: Int, gruposId: Int, postId: Int): GruposXpostXestudiantes?
}