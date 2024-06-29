package com.example.rickyapp

import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickyapp.navigation.HomeNavigation
import com.example.rickyapp.ui.screens.HomeScreen
import com.example.rickyapp.ui.theme.RickyAppTheme
import com.example.rickyapp.ui.theme.SurfaceBg
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            homeViewModel.getDataFromRepo()
            RickyAppTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(SurfaceBg)) {
                    HomeNavigation(homeViewModel)
                }
            }
        }
    }
}