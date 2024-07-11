package com.dev.eventify.navigation

import android.content.ContentValues
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.dev.eventify.ui.views.authenticated.UserProfileView
import com.dev.eventify.ui.views.unauthenticated.LoginScreenView
import com.dev.eventify.ui.views.unauthenticated.OnboardingScreenView
import com.dev.eventify.ui.views.unauthenticated.RegisterProfessorScreenView
import com.dev.eventify.ui.views.unauthenticated.RegisterStudentScreenView
import com.dev.eventify.ui.views.unauthenticated.SelectionScreenView

/**
 * viajar en Login, registration, forgot password
 * (Unauthenticated user)
 */
fun NavGraphBuilder.unauthenticatedGraph(navController: NavController){

    navigation(
        route = NavigationRoutes.Unauthenticated.DestinationRoute.route,
        startDestination = NavigationRoutes.Unauthenticated.Onboarding.route,
    ){

        // onboarding
        composable(route = NavigationRoutes.Unauthenticated.Onboarding.route) {
            OnboardingScreenView(

                navigateToLogin = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.Login.route)
                },

                navigateToRegistration = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.Selection.route)
                },

                navigateToAuthenticatedRoute = {
                    navController.navigate(route = NavigationRoutes.Authenticated.DestinationRoute.route){
                        popUpTo(route = NavigationRoutes.Unauthenticated.DestinationRoute.route){
                            inclusive = true
                        }
                    }
                },
            )
        }

        // login
        composable(route = NavigationRoutes.Unauthenticated.Login.route){
            LoginScreenView(

                navigateToRegistration = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.Selection.route)
                },

                navigateToForgotPassword = {},

                navigateToAuthenticatedRoute = {
                    navController.navigate(route = NavigationRoutes.Authenticated.DestinationRoute.route){
                        popUpTo(route = NavigationRoutes.Unauthenticated.DestinationRoute.route){
                           inclusive = true
                        }
                    }
                },

                navigateBack = {
                    navController.navigateUp()
                },

            )
        }

        // register selection
        composable(route = NavigationRoutes.Unauthenticated.Selection.route) {
            SelectionScreenView(
                navigateToRegisterProfessor = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.RegisterProfessor.route)
                },

                navigateToRegisterStudent = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.RegisterStudent.route)
                },

                navigateBack = {
                    navController.navigateUp()
                },
            )
        }

        // register professor
        composable(route = NavigationRoutes.Unauthenticated.RegisterProfessor.route) {
            RegisterProfessorScreenView(

                navigateToLogin = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.Login.route)
                },

                navigateToAuthenticatedRoute = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.Login.route){
                        popUpTo(route = NavigationRoutes.Unauthenticated.DestinationRoute.route){
                            inclusive = true
                        }
                    }
                },

                navigateBack = {
                    navController.navigateUp()
                },

                onSubmit = {
                        professor ->
                    Log.i(ContentValues.TAG, professor.toString())
                }

            )
        }

        // register students
        composable(route = NavigationRoutes.Unauthenticated.RegisterStudent.route) {
            RegisterStudentScreenView(

                navigateToLogin = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.Login.route)
                },

                navigateToAuthenticatedRoute = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.Login.route){
                        popUpTo(route = NavigationRoutes.Unauthenticated.DestinationRoute.route){
                            inclusive = true
                        }
                    }
                },

                navigateBack = {
                    navController.navigateUp()
                },

                onSubmit = {
                        students ->
                    Log.i(ContentValues.TAG, students.toString())
                }

            )
        }
    }
}

/**
 * entrar de inmediato al main screen
 * (Authenticated user)
 */
fun NavGraphBuilder.authenticatedGraph(navController: NavController){
    navigation(
        route = NavigationRoutes.Authenticated.DestinationRoute.route,
        startDestination = NavigationRoutes.Authenticated.UserProfile.route
    ){
        composable(route = NavigationRoutes.Authenticated.UserProfile.route){
            UserProfileView(
                navigateToUnauthenticatedRoute ={
                    navController.navigate(route = NavigationRoutes.Unauthenticated.DestinationRoute.route){
                        popUpTo(route = NavigationRoutes.Authenticated.DestinationRoute.route){
                            inclusive = true
                        }
                    }
                },
                navigateBack = {
                    navController.navigateUp()
                },
            )
        }
    }
}