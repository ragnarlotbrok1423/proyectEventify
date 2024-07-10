package com.dev.eventify.interactors

import com.dev.eventify.entities.EstudiantesInterface
import com.dev.eventify.entities.GetInterface
import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.Estudiantes
import com.dev.eventify.entities.models.Facultades
import com.dev.eventify.entities.models.FacultadesXpostsXprofesores
import com.dev.eventify.entities.models.GruposXpostXestudiantes
import com.dev.eventify.entities.models.Materia
import com.dev.eventify.entities.models.Profesores

class GetInteractor (private val apiService: EventifyApiService): GetInterface {

    override suspend fun getFacultades(): Facultades?{
        return try{
            apiService.getFacultades()
        }
        catch (e: Exception){
            error(e)
        }
    }

    override suspend fun getStudent(): Estudiantes? {
        return try{
            apiService.getStudent()
        }
        catch (e: Exception){
            error(e)
        }
    }

    override suspend fun getProfessor(): Profesores? {
        return try{
            apiService.getProfessor()
        }
        catch (e: Exception){
            error(e)
        }
    }

    override suspend fun getMaterial(): Materia? {
        return try{
            apiService.getMaterial()
        }
        catch (e: Exception){
            error(e)
        }
    }

    override suspend fun getGroupPublication(): GruposXpostXestudiantes? {
        return try{
            apiService.getGroupPublication()
        }
        catch (e: Exception){
            error(e)
        }
    }

    override suspend fun getPublication(): FacultadesXpostsXprofesores? {
        return try{
            apiService.getPublication()
        }
        catch (e: Exception){
            error(e)
        }
    }
}