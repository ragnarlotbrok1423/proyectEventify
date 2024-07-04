package com.dev.eventify.navigation

sealed class NavigationRoutes {

    sealed class Unauthenticated(val route: String) : NavigationRoutes(){
        object DestinationRoute : Unauthenticated(route = "unauthenticated")
        object Login : Unauthenticated(route = "login")
        object Register : Unauthenticated(route = "register")

    }

    sealed class Authenticated(val route: String) : NavigationRoutes(){
        object DestinationRoute : Authenticated(route = "authenticated")
        object UserProfile : Authenticated(route = "userProfile")

    }
}