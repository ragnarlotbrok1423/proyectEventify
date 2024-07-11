package com.dev.eventify.entities.models

data class Valoraciones(

    val valoracion:Int,
    val comentario:String?
)
data class ValoracionesResponse(
    val valoracionId: Int,
    val valoracion:Int,
    val comentario:String?)
