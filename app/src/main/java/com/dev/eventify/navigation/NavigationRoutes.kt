package com.dev.eventify.navigation

sealed class NavigationRoutes {

    sealed class Unauthenticated(val route: String) : NavigationRoutes(){
        object DestinationRoute : Unauthenticated(route = "unauthenticated")
        object Onboarding: Unauthenticated(route = "onboarding")
        object Login : Unauthenticated(route = "login")
        object RegisterProfessor : Unauthenticated(route = "register_professor")
        object RegisterStudent : Unauthenticated(route = "register_student")
        object Selection : Unauthenticated(route = "selection")


    }

    sealed class Authenticated(val route: String) : NavigationRoutes(){
        object DestinationRoute : Authenticated(route = "authenticated")
        object UserProfile : Authenticated(route = "userProfile")

    }
}