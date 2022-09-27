package com.empedocles.pomodoroappbuild.ui

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.empedocles.pomodoroappbuild.presentation.MainScreenViewModel
import com.empedocles.pomodoroappbuild.util.TimeStringConstants
import com.empedocles.pomodoroappbuild.util.timeStamp

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = viewModel.getLongToTimeStamp())
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = {
            viewModel.startStop()
            println(viewModel.isTimerRunning.value)
        }) {
            Text(text = if (viewModel.isTimerRunning.value) "STOP" else "START")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { viewModel.changeTimeMethod(TimeStringConstants.POMODORO) }) {
                Text(text = TimeStringConstants.POMODORO)
            }
            Button(onClick = { viewModel.changeTimeMethod(TimeStringConstants.SHORT_BREAK) }) {
                Text(text = TimeStringConstants.SHORT_BREAK)
            }
            Button (onClick = { viewModel.changeTimeMethod(TimeStringConstants.LONG_BREAK) }) {
                Text(text = TimeStringConstants.LONG_BREAK)
            }
        }
    }
}

