package com.example.peliculas.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Peliculas(navController: NavHostController, peliculaViewModel: PeliculaViewModel = viewModel()){
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(peliculaViewModel.peliculas){ pelicula ->
                ElevatedCard(modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()) {

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Titulo: ${pelicula.titulo}")
                        Text("Sinopsis: ${pelicula.sinopsis}")
                        Text("Duración: ${pelicula.duracion}")
                        Text("Genero: ${pelicula.genero}")
                        pelicula.imagenUri?.let {
                            GlideImage(imageModel = it, modifier = Modifier.size(150.dp))
                        }
                    }
                }                
            }

        }
    }
}