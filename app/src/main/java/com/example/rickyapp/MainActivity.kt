package com.example.rickyapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickyapp.ui.screens.HomeScreen
import com.example.rickyapp.ui.theme.RickyAppTheme
import com.example.rickyapp.ui.theme.SurfaceBg

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickyAppTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(SurfaceBg)) {
                    HomeScreen()
                }
            }
        }
        Log.e("sss/", "onCreate...")
    }

    override fun onResume() {
        super.onResume()
        Log.e("sss/", "onResume...")
    }

    override fun onPause() {
        super.onPause()
        Log.e("sss/", "onPause...")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("sss/", "onRestart...")
    }

    override fun onStop() {
        super.onStop()
        Log.e("sss/", "onStop...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("sss/", "onDestroy...")
    }

    override fun onStart() {
        super.onStart()
        Log.e("sss/", "onStart...")
    }

}