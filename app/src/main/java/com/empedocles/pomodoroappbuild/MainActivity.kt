package com.empedocles.pomodoroappbuild

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.empedocles.pomodoroappbuild.presentation.MainScreenViewModel
import com.empedocles.pomodoroappbuild.ui.MainScreen
import com.empedocles.pomodoroappbuild.ui.theme.PomodoroAppBuildTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : MainScreenViewModel by viewModels()
        setContent {
            PomodoroAppBuildTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(color = Color(0xFF1E213F))
                ) {
                    MainScreen(viewModel =  viewModel)
                }
            }
        }
    }
}

