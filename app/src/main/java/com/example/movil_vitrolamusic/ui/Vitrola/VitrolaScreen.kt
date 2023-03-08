package com.example.movil_vitrolamusic.ui.Vitrola

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movil_vitrolamusic.data.remodo.dto.Music
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import com.example.movil_vitrolamusic.ui.theme.Red200

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VitrolaScreen(
    viewModel: VitrolaViewModel = hiltViewModel()
) {

    val musicList by viewModel.musicList.collectAsState(initial = emptyList())


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Lista de Canciones",
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.onPrimary,
                            textAlign = TextAlign.Center
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.onSecondary,
            )
        },
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
            ) {
                items(musicList) { music ->
                    VitrolaItem(music )
                }
            }

        }
    }
}

@Composable
fun VitrolaItem(
    music: Music,
    viewModel: VitrolaViewModel = hiltViewModel()
) {
    var showDialog by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .clickable {showDialog = true   }
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.MusicNote, // Utiliza el icono de música de los iconos rellenos de Material Design
                contentDescription = "Icono de música",
                modifier = Modifier.size(50.dp),
                tint = Red200
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(60.dp,0.dp,0.dp,0.dp)
                ,
            verticalArrangement = Arrangement.Center,

        ) {
            Text(
                text = music.artist,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = music.titulo,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Agregar música") },
            text = { Text("¿Está seguro de que desea agregar esta música?") },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.postMusic(music)
                        showDialog = false
                    }
                ) {
                    Text("Agregar")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Denegar")
                }
            }
        )
    }
}
