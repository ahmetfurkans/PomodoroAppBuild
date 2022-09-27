package com.empedocles.pomodoroappbuild.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.empedocles.pomodoroappbuild.presentation.MainScreenViewModel
import com.empedocles.pomodoroappbuild.util.TimeStringConstants

@Composable
fun CustomButton(viewModel : MainScreenViewModel, timeMethod : String){
    Button(
        colors = if (viewModel.selectedTimeMethod.value == timeMethod) ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFF87070)
        )
        else ButtonDefaults.buttonColors(backgroundColor = Color(0xFF161932)),

        onClick = { viewModel.changeTimeMethod(timeMethod) },
        shape = RoundedCornerShape(26.dp),
        modifier = Modifier
            .width(105.dp)
            .height(48.dp)
    ) {
        Text(
            text = timeMethod,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD7E0FF)
        )
    }
}