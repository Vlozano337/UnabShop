package co.edu.unab.valerialozano.unabshop

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationApp(){

    val myNavController = rememberNavController()
    val myStartDeclaration: String = "login"

    NavHost(
        navController = myNavController,
        startDestination = myStartDeclaration
    ){
        composable ("login") {
            LoginScreen(onClickRegister = {

                myNavController.navigate("register")

            } )
        }
        composable ("register") {
            RegisterScreen(onClickBack = {
                myNavController.popBackStack()
            })
        }
    }

}


