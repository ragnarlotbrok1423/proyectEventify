package com.dev.eventify.interactors

import com.dev.eventify.entities.ValoracionesInteractorInterface
import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ValoracionesInteractor(private val apiService: EventifyApiService):  ValoracionesInteractorInterface {
    override suspend fun createValoration(valoracion: Int, comentario: String?): Result<Int> {
        return withContext(Dispatchers.IO){
            try {
                val response = apiService.createValoracion(valoracion,comentario)
                if(response.isSuccessful){
                    val valoracionId= response.body()?.valoracionId ?:0
                    Result(data=valoracionId, error = null)
                }else{
                    Result(data=null, error = "No se pudo crear la valoración")
                }
            }catch (e: Exception){
                Result(data=null, error = "No se pudo crear la valoración")
            }
        }
    }

    override suspend fun incognitePost(
        estudianteId: Int,
        profesorId: Int,
        valoracionId: Int
    ): Result<Boolean> {
        return withContext(Dispatchers.IO){
            try {
                val response= apiService.createIncognitePost(estudianteId,profesorId,valoracionId)
                if(response.isSuccessful){
                    Result(data=true, error = null)
                }else{
                    Result(data=null, error = "No se pudo crear la valoración")
                }
            }catch (e: Exception){
                Result(data=null, error = "No se pudo crear la valoración")
            }
        }
    }
}