package com.example.peliculas.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class Pelicula(
    val titulo:String,
    val sinopsis:String,
    val duracion:String,
    val genero:String
)

class PeliculaViewModel : ViewModel() {
    // Lista para almacenar las películas
    val peliculas = mutableStateListOf<Pelicula>()

    // Función para agregar una nueva película
    fun agregarPelicula(pelicula: Pelicula) {
        peliculas.add(pelicula)
    }
}