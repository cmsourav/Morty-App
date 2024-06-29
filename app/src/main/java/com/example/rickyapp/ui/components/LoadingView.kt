package com.example.rickyapp.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.rickyapp.ui.theme.SurfaceBlack

@Composable
fun LoadingView() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(color = SurfaceBlack)
    }
}

@Composable
fun ErrorToastMessage(message: String) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}