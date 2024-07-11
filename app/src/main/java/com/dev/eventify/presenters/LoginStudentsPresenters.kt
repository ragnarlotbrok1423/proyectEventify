package com.dev.eventify.presenters

import com.dev.eventify.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

interface LoginContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun showLoginSuccess(estudiante: Estudiantes)
        fun showLoginError(error: String)
    }

    class Presenter(private val view: MainActivity, private val interactor: LoginEstudentInteractor) {

        fun login(nickName: String, password: String) {
            view.showProgress()

            GlobalScope.launch(Dispatchers.Main) {
                val result = interactor.loginEstudent(nickName, password)

                if (result.data != null) {
                    view.hideProgress()
                    view.showLoginSuccess(result.data)
                } else {
                    view.hideProgress()
                    view.showLoginError(result.error ?: "Error desconocido")
                }
            }
        }
    }
}