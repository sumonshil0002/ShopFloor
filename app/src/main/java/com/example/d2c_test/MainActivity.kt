package com.example.d2c_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.d2c_test.screens.home.HomeScreen
import com.example.d2c_test.screens.home.TopBar
import com.example.d2c_test.ui.theme.D2CTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            D2CTestTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ){innerPadding->
                    HomeScreen(innerPadding)
                }

            }
        }
    }
}

