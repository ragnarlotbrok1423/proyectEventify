package com.dev.eventify.interactors

import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.Valoraciones
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.dev.eventify.entities.models.Result
import com.dev.eventify.entities.models.ValoracionesResponse

class ProfesorXcalificacion(private val apiService: EventifyApiService) {
    suspend fun obtenerValoraciones(profesorId:Int): Result<List<ValoracionesResponse>>{
        return withContext(Dispatchers.IO){
            try {
                val response = apiService.profesoresXcalificacion(profesorId)
                if (response.isSuccessful){
                    Result(data=response.body(), error=null)
                }else{
                    Result(data=null, error="Algo paso")
                }
            }catch (e:Exception){
                Result(data=null, error="Algo paso")
            }
        }
    }
}