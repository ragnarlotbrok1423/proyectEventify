package com.dev.eventify

import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dev.eventify.ui.themes.EventifyTheme



import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dev.eventify.entities.apiService.EventifyService
import com.dev.eventify.entities.models.Estudiantes
import com.dev.eventify.interactors.LoginEstudentInteractor
import com.dev.eventify.presenters.LoginContract


public class MainActivity : AppCompatActivity() {

    private lateinit var presenter: LoginContract.Presenter

    private lateinit var nicknameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var progressBar: ProgressBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nicknameEditText = findViewById(R.id.nicknameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        progressBar = findViewById(R.id.progressBar)

        val apiService = EventifyService.instance
        val interactor = LoginEstudentInteractor(apiService)
        presenter = LoginContract.Presenter(this, interactor)

        loginButton.setOnClickListener {
            val nickname = nicknameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            presenter.login(nickname, password)
        }
    }

    fun showProgress() {
        progressBar.visibility = ProgressBar.VISIBLE
    }

    fun hideProgress() {
        progressBar.visibility = ProgressBar.GONE
    }

    fun showLoginSuccess(estudiante: Estudiantes) {
        hideProgress()
        Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show()

        // Iniciar la actividad ProfileView
        startActivity(intent)
    }

    fun showLoginError(error: String) {
        hideProgress()
        Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
    }
}
