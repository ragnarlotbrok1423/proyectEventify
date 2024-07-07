package com.dev.eventify.entities

import com.dev.eventify.entities.models.Comentario

interface ComentariosInteractors {
    suspend fun createComentario(profesorId: Int, materiaId: Int, valoracion: Int, comentario: String): Comentario?
    suspend fun getComentariosByProfesor(profesorId: Int): List<Comentario>?
}

