package com.example.rickyapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.rickyapp.HomeViewModel
import com.example.rickyapp.model.CharacterData
import com.example.rickyapp.model.Result
import com.example.rickyapp.navigation.HomeNav
import com.example.rickyapp.ui.components.CharacterList
import com.example.rickyapp.ui.components.ErrorToastMessage
import com.example.rickyapp.ui.components.HeaderSection
import com.example.rickyapp.ui.components.LoadingView
import com.example.rickyapp.ui.theme.SurfaceBg
import com.example.rickyapp.ui.utils.UIState

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel,
) {
    when (val uiState = homeViewModel.uiState.collectAsState().value) {
        is UIState.Empty -> Unit

        is UIState.Loading -> {
            LoadingView()
        }

        is UIState.Loaded<*> -> {
            val data = uiState.result as CharacterData
            data.results?.let {
                MainView(navController = navController, homeViewModel = homeViewModel, data = it)
            }
        }

        is UIState.Error -> {
            ErrorToastMessage(message = uiState.exception.message.toString())
        }
    }
}

@Composable
private fun MainView(
    navController: NavController,
    homeViewModel: HomeViewModel,
    data: List<Result>,
) {
    Scaffold(
        topBar = { HeaderSection(title = "Ricky App") },
        content = {
            Surface(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(it),
                color = SurfaceBg
            ) {
                CharacterList(data = data) { result ->
                    homeViewModel.sharedResult.value = result
                    navController.navigate(HomeNav.DETAIL_SCREEN)
                }
            }
        },
    )
}