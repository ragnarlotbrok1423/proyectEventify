package com.dev.eventify.entities

import com.dev.eventify.entities.models.Facultades

interface GetInterface {

    suspend fun getFacultades():Facultades?
}