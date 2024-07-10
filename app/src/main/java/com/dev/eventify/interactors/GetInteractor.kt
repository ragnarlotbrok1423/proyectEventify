package com.dev.eventify.interactors

import com.dev.eventify.entities.EstudiantesInterface
import com.dev.eventify.entities.GetInterface
import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.Facultades

class GetInteractor (private val apiService: EventifyApiService): GetInterface {

    override suspend fun getFacultades(): Facultades?{
        return try{
            apiService.getFacultades()
        }
        catch (e: Exception){
            error(e)
        }
    }
}