package com.dev.eventify.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.dev.eventify.ui.views.authenticated.UserProfileView
import com.dev.eventify.ui.views.unauthenticated.LoginScreenView
import com.dev.eventify.ui.views.unauthenticated.RegisterScreenView

/**
 * viajar en Login, registration, forgot password
 * (Unauthenticated user)
 */
fun NavGraphBuilder.unauthenticatedGraph(navController: NavController){

    navigation(
        route = NavigationRoutes.Unauthenticated.DestinationRoute.route,
        startDestination = NavigationRoutes.Unauthenticated.Login.route,
    ){

        // login
        composable(route = NavigationRoutes.Unauthenticated.Login.route){
            LoginScreenView(

                navigateToRegistration = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.Register.route)
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

        composable(route = NavigationRoutes.Unauthenticated.Register.route) {
            RegisterScreenView(

                navigateToLogin = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.Login.route)
                },

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
            UserProfileView()
        }
    }
}