package com.dev.eventify.presenters

import com.dev.eventify.entities.RegisterViewInterface
import com.dev.eventify.interactors.EstudianteRegisterInteractor
import com.dev.eventify.interactors.ProfesorInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class RegisterProfesorPresenter(private val view: RegisterViewInterface,
    private val interactor: ProfesorInteractor
    ) {
    fun createProfesor(nombre: String, apellido: String, email: String, password: String){
        CoroutineScope(Dispatchers.Main).launch {
            val result= interactor.createProfesor(nombre,apellido,email,password,2,null,null)
            if (result.data != null){
                view.navigateTo()
            }else{
                view.showError(result.error ?: "No se ha podido loguear correctamente")
            }
        }
    }
}