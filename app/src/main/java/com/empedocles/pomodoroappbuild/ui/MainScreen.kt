package com.empedocles.pomodoroappbuild.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.empedocles.pomodoroappbuild.presentation.MainScreenViewModel
import com.empedocles.pomodoroappbuild.util.TimeStringConstants

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {

    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxSize()
    ) {
        Text(
            color = Color(0xffD7E0FF),
            modifier = Modifier.padding(top = 32.dp),
            text = "pomodoro",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(350.dp)
                .height(70.dp)
                .background(color = Color(0xFF161932), shape = RoundedCornerShape(31.dp))
        ) {
            CustomButton(viewModel = viewModel, TimeStringConstants.POMODORO)
            CustomButton(viewModel = viewModel, TimeStringConstants.SHORT_BREAK)
            CustomButton(viewModel = viewModel, TimeStringConstants.LONG_BREAK)

        }

        TimerArc(viewModel = viewModel)

        Text(
            letterSpacing = 13.sp,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD7E0FF),
            text = if (viewModel.isTimerRunning.value) "STOP" else "START",
            modifier = Modifier.clickable {
                viewModel.startStop()
                println(viewModel.isTimerRunning.value)
            })

        SettingsButton(context = context)

    }
}



