package com.dev.eventify.presenters

import com.dev.eventify.entities.LoginViewInterface
import com.dev.eventify.interactors.LoginEstudentInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginStudentPresenter(private val interactor:LoginEstudentInteractor,
    private val view: LoginViewInterface
    ) {
    fun loginStudent(nickname:String, password:String){
        CoroutineScope(Dispatchers.Main).launch {
            val result= interactor.loginEstudent(nickname,password)
            if (result.data != null){
                view.onLoginSuccess(result.data.first, result.data.second)
            }else{
                view.onLoginError(result.error ?: "No se ha podido loguear correctamente")
            }
        }
    }
}