package com.dev.eventify.entities

import com.dev.eventify.entities.models.Result

interface ValoracionesInteractorInterface {
    suspend fun createValoration (valoracion:Int, comentario:String?):Result<Int>
    suspend fun incognitePost(estudianteId:Int, profesorId:Int, valoracionId:Int): Result<Boolean>
}