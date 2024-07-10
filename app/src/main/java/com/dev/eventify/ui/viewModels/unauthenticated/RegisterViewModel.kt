package com.dev.eventify.ui.viewModels.unauthenticated

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dev.eventify.data.state.ErrorState
import com.dev.eventify.data.state.register.RegisterErrorState
import com.dev.eventify.data.state.register.RegisterState
import com.dev.eventify.data.state.register.RegisterUiEvent
import com.dev.eventify.data.state.register.careerEmptyErrorState
import com.dev.eventify.data.state.register.emailEmptyErrorState
import com.dev.eventify.data.state.register.facultyEmptyErrorState
import com.dev.eventify.data.state.register.levelEmptyErrorState
import com.dev.eventify.data.state.register.nicknameEmptyErrorState
import com.dev.eventify.data.state.register.passwordEmptyErrorState
import com.dev.eventify.data.state.register.phoneNumberEmptyErrorState

class RegisterViewModel: ViewModel() {
    
    var registerState = mutableStateOf(RegisterState())
        private set


    fun onRegisterUiEvent(registerUiEvent: RegisterUiEvent){
        when(registerUiEvent){
            is RegisterUiEvent.NicknameChange -> {
                registerState.value = registerState.value.copy(
                    nickname = registerUiEvent.inputValue,
                    errorState = registerState.value.errorState.copy(
                        nicknameErrorState = if(registerUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            nicknameEmptyErrorState
                    )
                )
            }

            is RegisterUiEvent.EmailChage -> {
                registerState.value = registerState.value.copy(
                    email = registerUiEvent.inputValue,
                    errorState = registerState.value.errorState.copy(
                        emailErrorState = if(registerUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            emailEmptyErrorState
                    )
                )
            }

            is RegisterUiEvent.PasswordChange -> {
                registerState.value = registerState.value.copy(
                    password = registerUiEvent.inputValue,
                    errorState = registerState.value.errorState.copy(
                        emailErrorState = if(registerUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            emailEmptyErrorState
                    )
                )
            }

            is RegisterUiEvent.PhoneNumberChange -> {
                registerState.value = registerState.value.copy(
                    phoneNumber = registerUiEvent.inputValue,
                    errorState = registerState.value.errorState.copy(
                        phoneNumberErrorState = if(registerUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            phoneNumberEmptyErrorState
                    )
                )
            }

            is RegisterUiEvent.FacultyChange -> {
                registerState.value = registerState.value.copy(
                    faculty = registerUiEvent.inputValue,
                    errorState = registerState.value.errorState.copy(
                        facultyErrorState = if(registerUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            facultyEmptyErrorState
                    )
                )
            }

            is RegisterUiEvent.CareerChange -> {
                registerState.value = registerState.value.copy(
                    career = registerUiEvent.inputValue,
                    errorState = registerState.value.errorState.copy(
                        careerErrorState = if(registerUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            careerEmptyErrorState
                    )
                )
            }

            is RegisterUiEvent.LevelChange -> {
                registerState.value = registerState.value.copy(
                    level = registerUiEvent.inputValue,
                    errorState = registerState.value.errorState.copy(
                        levelErrorState = if(registerUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            levelEmptyErrorState
                    )
                )
            }

            is RegisterUiEvent.Submit -> {
                val inputValidated = validateInputs()
                if(inputValidated)
                    registerState.value = registerState.value.copy(isRegisterSuccessful = true)
            }
        }
    }
    
    private fun validateInputs(): Boolean{
        val nickname = registerState.value.nickname.trim()
        val email = registerState.value.email.trim()
        val password = registerState.value.password
        val phoneNumber = registerState.value.phoneNumber.trim()
        val faculty = registerState.value.faculty.trim()
        val career = registerState.value.career.trim()
        val level = registerState.value.level.trim()
        return when {
    
            nickname.isEmpty() -> {
                registerState.value = registerState.value.copy(
                    errorState = RegisterErrorState(nicknameErrorState = nicknameEmptyErrorState)
                )
                false
            }

            email.isEmpty() -> {
                registerState.value = registerState.value.copy(
                    errorState = RegisterErrorState(emailErrorState = emailEmptyErrorState)
                )
                false
            }
    
            password.isEmpty() -> {
                registerState.value = registerState.value.copy(
                    errorState = RegisterErrorState(passwordErrorState = passwordEmptyErrorState)
                )
                false
            }

            phoneNumber.isEmpty() -> {
                registerState.value = registerState.value.copy(
                    errorState = RegisterErrorState(phoneNumberErrorState = phoneNumberEmptyErrorState)
                )
                false
            }

            faculty.isEmpty() -> {
                registerState.value = registerState.value.copy(
                    errorState = RegisterErrorState(facultyErrorState = facultyEmptyErrorState)
                )
                false
            }

            career.isEmpty() -> {
                registerState.value = registerState.value.copy(
                    errorState = RegisterErrorState(careerErrorState = careerEmptyErrorState)
                )
                false
            }

            level.isEmpty() -> {
                registerState.value = registerState.value.copy(
                    errorState = RegisterErrorState(levelErrorState = levelEmptyErrorState)
                )
                false
            }
    
            // Cuando no hay errores, se envia como true y limpia los inputs
            else -> {
                registerState.value = registerState.value.copy(errorState = RegisterErrorState())
                true
            }
        }
    }
}

