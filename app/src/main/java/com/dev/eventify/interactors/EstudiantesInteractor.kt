package com.dev.eventify.interactors

import com.dev.eventify.entities.EstudiantesInterface
import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.Estudiantes
import com.dev.eventify.entities.models.GruposXpostXestudiantes

class EstudiantesInteractor(private val apiService: EventifyApiService): EstudiantesInterface{
    override suspend fun createEstudiantes(
        nickname: String,
        password: String,
        imagen: String,
        descripcion: String,
        facultadesId: Int
    ): Estudiantes? {
        return try {
            apiService.createEstudiantes(Estudiantes(nickname, password, imagen, descripcion, facultadesId))
        }
        catch (e: Exception){
            error(e)
        }
    }

    override suspend fun postGrupos(
        estudiantesId: Int,
        gruposId: Int,
        postId: Int
    ): GruposXpostXestudiantes? {
        return try{
            apiService.createGroupPublication(GruposXpostXestudiantes(estudiantesId, gruposId, postId))
        }
        catch (e:Exception){
            error(e)
        }
    }
}
