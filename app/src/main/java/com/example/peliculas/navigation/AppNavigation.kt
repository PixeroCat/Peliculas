package com.example.peliculas.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.peliculas.screen.PeliculaViewModel
import com.example.peliculas.screen.Peliculas
import com.example.peliculas.screen.Registro

@Composable
fun AppNavigation(peliculaViewModel : PeliculaViewModel = viewModel()){
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "registro"){
        composable("registro"){
            Registro(navController, peliculaViewModel)
        }
        composable("peliculas"){
            Peliculas(navController, peliculaViewModel)
        }
    }
}