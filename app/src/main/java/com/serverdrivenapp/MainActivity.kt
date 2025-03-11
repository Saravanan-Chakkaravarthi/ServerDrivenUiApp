package com.serverdrivenapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.serverdrivenapp.navigation.AppNavigation
import com.serverdrivenapp.ui.theme.ServerDrivenAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ServerDrivenAppTheme {
                val navController = rememberNavController()

                AppNavigation(navHostController = navController)

            }
        }
    }
}

