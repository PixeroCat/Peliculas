package com.example.peliculas.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registro(navController: NavHostController, peliculaViewModel: PeliculaViewModel = viewModel()) {

    var titulo by remember { mutableStateOf("") }
    var sinopsis by remember { mutableStateOf("") }
    var duracion by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Peliculas",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer) {
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { navController.navigate("registro") }) {

                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Add"
                    )
                }
                Spacer(modifier = Modifier.width(32.dp))

                IconButton(onClick = { navController.navigate("peliculas") }) {
                    Icon(
                        Icons.Filled.AccountBox,
                        contentDescription = "Movies"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        },
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = titulo,
                onValueChange = { titulo = it },
                label = { Text("Titulo") }
            )
            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextField(
                value = sinopsis,
                onValueChange = { sinopsis = it },
                label = { Text("Sinopsis") }
            )
            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextField(
                value = duracion,
                onValueChange = { duracion = it },
                label = { Text("Duracion") }
            )
            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextField(
                value = genero,
                onValueChange = { genero = it },
                label = { Text("Genero") }
            )
            Spacer(modifier = Modifier.height(5.dp))

            Button(
                onClick = {
                    val nuevaPelicula = Pelicula(titulo, sinopsis, duracion, genero)
                    peliculaViewModel.agregarPelicula(nuevaPelicula)
                    navController.navigate("peliculas")
                }) {
                Text("Registrar")
            }
        }

    }
}