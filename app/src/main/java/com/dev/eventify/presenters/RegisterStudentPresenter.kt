package com.dev.eventify.presenters

import com.dev.eventify.entities.RegisterViewInterface
import com.dev.eventify.interactors.EstudianteRegisterInteractor
import com.dev.eventify.interactors.ProfesorInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterStudentPresenter (private val view: RegisterViewInterface,
                                private val interactor: EstudianteRegisterInteractor
) {
    fun createEstudiante(nickname:String, password:String, facultadId:Int){
        CoroutineScope(Dispatchers.Main).launch {
            val result= interactor.createStudent(nickname,password,null,null,1,facultadId)
            if (result.data != null){
                view.navigateTo()
            }else{
                view.showError(result.error ?: "No se ha podido Registrar correctamente")
            }
        }
    }
}