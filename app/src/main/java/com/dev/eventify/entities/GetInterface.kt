package com.dev.eventify.entities

import com.dev.eventify.entities.models.Estudiantes
import com.dev.eventify.entities.models.Facultades
import com.dev.eventify.entities.models.FacultadesXpostsXprofesores
import com.dev.eventify.entities.models.GruposXpostXestudiantes
import com.dev.eventify.entities.models.Materia
import com.dev.eventify.entities.models.Profesores

interface GetInterface {

    suspend fun getFacultades():Facultades?

    suspend fun getStudent(): Estudiantes?

    suspend fun getProfessor(): Profesores?

    suspend fun getMaterial(): Materia?

    suspend fun getGroupPublication(): GruposXpostXestudiantes?

    suspend fun getPublication(): FacultadesXpostsXprofesores?
}