package com.dev.eventify.interactors



import androidx.compose.animation.rememberSplineBasedDecay
import com.dev.eventify.entities.PostsInteractors
import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.FacultadesXpostsXprofesores
import com.dev.eventify.entities.models.Post


class PostInteractor(private val apiService: EventifyApiService) : PostsInteractors{
    override suspend fun createPost(titulo: String, descripcion: String, imagen: String): Post? {
        return try {
             apiService.createPost(Post(titulo,descripcion,imagen))

        }catch (e: Exception){
            null
        }
    }

    override suspend fun postFacultades(
        idProfesor: Int,
        idFacultad: Int,
        idPost: Int
    ): FacultadesXpostsXprofesores? {
        return try {
            apiService.createPublication(FacultadesXpostsXprofesores(idProfesor,idFacultad,idPost))

        }catch (e: Exception){
            null
        }
    }

}
