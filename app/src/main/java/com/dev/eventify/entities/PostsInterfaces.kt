package com.dev.eventify.entities

import com.dev.eventify.entities.models.FacultadesXpostsXprofesores
import com.dev.eventify.entities.models.Post

interface PostsInteractors {
    suspend fun createPost(title: String, description: String, image: String): Post?
    suspend fun postFacultades(idProfesor: Int, idFacultad: Int, idPost: Int): FacultadesXpostsXprofesores?
}



