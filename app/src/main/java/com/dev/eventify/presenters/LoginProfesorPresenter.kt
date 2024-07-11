package com.dev.eventify.presenters

import com.dev.eventify.entities.LoginViewInterface
import com.dev.eventify.interactors.LoginProfesorInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginProfesorPresenter(private val interactor:LoginProfesorInteractor
, private val view: LoginViewInterface) {
    fun loginProfesor(email:String,password:String){
        CoroutineScope(Dispatchers.Main).launch {
            val result= interactor.loginProfesor(email,password)
            if (result.data != null){
                view.onLoginSuccess(result.data.first, result.data.second)
            }else{
                view.onLoginError(result.error ?: "No se ha podido loguear correctamente")
            }
        }
    }
}