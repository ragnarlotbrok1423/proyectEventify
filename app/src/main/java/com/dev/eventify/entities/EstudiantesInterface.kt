package com.dev.eventify.entities

import android.provider.ContactsContract.CommonDataKinds.Nickname
import com.dev.eventify.entities.models.Estudiantes
import com.dev.eventify.entities.models.EstudiantesResponse
import com.dev.eventify.entities.models.Facultades
import com.dev.eventify.entities.models.Result

interface EstudiantesInterface {
    suspend fun createStudent(nickname:String, password:String,imagen:String?,descripcion:String?, rol:Int,facultadesId:Int): Result<Boolean>
    suspend fun getFacultades(): Result<List<Facultades>>

}
interface EstudiantesPresenter{
    fun createStudent(nickname:String, password:String,facultadesId:Int, rol:Int)
    fun getFacultades()


}