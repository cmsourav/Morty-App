package com.example.rickyapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickyapp.model.Result
import com.example.rickyapp.ui.components.CharacterList
import com.example.rickyapp.ui.components.HeaderSection
import com.example.rickyapp.ui.theme.SurfaceBg

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val data =
        listOf(
            Result(
                created = "2018-01-10T18:20:41.703Z",
                episode = listOf("https://rickandmortyapi.com/api/episode/27"),
                gender = "Male",
                id = 361,
                image = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
                name = "Toxic Rick",
                status = "Dead",
                location = null,
                origin = null,
                species = "Humanoid",
                type = "Rick's Toxic Side",
                url = "https://rickandmortyapi.com/api/character/361",
            ),
            Result(
                created = "2018-01-10T18:20:41.703Z",
                episode = listOf("https://rickandmortyapi.com/api/episode/27"),
                gender = "Male",
                id = 361,
                image = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
                name = "Toxic Rick",
                status = "Dead",
                location = null,
                origin = null,
                species = "Humanoid",
                type = "Rick's Toxic Side",
                url = "https://rickandmortyapi.com/api/character/361",
            ),
            Result(
                created = "2018-01-10T18:20:41.703Z",
                episode = listOf("https://rickandmortyapi.com/api/episode/27"),
                gender = "Male",
                id = 361,
                image = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
                name = "Toxic Rick",
                status = "Dead",
                location = null,
                origin = null,
                species = "Humanoid",
                type = "Rick's Toxic Side",
                url = "https://rickandmortyapi.com/api/character/361",
            ),
            Result(
                created = "2018-01-10T18:20:41.703Z",
                episode = listOf("https://rickandmortyapi.com/api/episode/27"),
                gender = "Male",
                id = 361,
                image = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
                name = "Toxic Rick",
                status = "Dead",
                location = null,
                origin = null,
                species = "Humanoid",
                type = "Rick's Toxic Side",
                url = "https://rickandmortyapi.com/api/character/361",
            ),
            Result(
                created = "2018-01-10T18:20:41.703Z",
                episode = listOf("https://rickandmortyapi.com/api/episode/27"),
                gender = "Male",
                id = 361,
                image = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
                name = "Toxic Rick",
                status = "Dead",
                location = null,
                origin = null,
                species = "Humanoid",
                type = "Rick's Toxic Side",
                url = "https://rickandmortyapi.com/api/character/361",
            ),
            Result(
                created = "2018-01-10T18:20:41.703Z",
                episode = listOf("https://rickandmortyapi.com/api/episode/27"),
                gender = "Male",
                id = 361,
                image = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
                name = "Toxic Rick",
                status = "Dead",
                location = null,
                origin = null,
                species = "Humanoid",
                type = "Rick's Toxic Side",
                url = "https://rickandmortyapi.com/api/character/361",
            ),
            Result(
                created = "2018-01-10T18:20:41.703Z",
                episode = listOf("https://rickandmortyapi.com/api/episode/27"),
                gender = "Male",
                id = 361,
                image = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
                name = "Toxic Rick",
                status = "Dead",
                location = null,
                origin = null,
                species = "Humanoid",
                type = "Rick's Toxic Side",
                url = "https://rickandmortyapi.com/api/character/361",
            ),
            Result(
                created = "2018-01-10T18:20:41.703Z",
                episode = listOf("https://rickandmortyapi.com/api/episode/27"),
                gender = "Male",
                id = 361,
                image = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
                name = "Toxic Rick",
                status = "Dead",
                location = null,
                origin = null,
                species = "Humanoid",
                type = "Rick's Toxic Side",
                url = "https://rickandmortyapi.com/api/character/361",
            ),
        )
    val context = LocalContext.current

    Scaffold(
        topBar = { HeaderSection(title = "Ricky App") },
        content = {
            Surface(modifier = modifier.fillMaxSize().background(SurfaceBg).padding(it)) {
                CharacterList(data = data) {
                    Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        },
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}