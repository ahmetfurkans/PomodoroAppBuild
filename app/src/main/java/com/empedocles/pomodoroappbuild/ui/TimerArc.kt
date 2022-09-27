package com.empedocles.pomodoroappbuild.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.empedocles.pomodoroappbuild.presentation.MainScreenViewModel

@Composable
fun TimerArc(viewModel: MainScreenViewModel) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Spacer(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .background(Color(0xFF282D52), shape = CircleShape)
        )
        Spacer(
            modifier = Modifier
                .width(268.dp)
                .height(268.dp)
                .background(Color(0xFF161932), shape = CircleShape)
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(245.dp)
                .onSizeChanged {
                    viewModel.arcSize.value = it
                }
        ) {
            Canvas(modifier = Modifier.size(245.dp)) {
                drawArc(
                    color = Color(0xFFF87070),
                    startAngle = 0f,
                    sweepAngle = 360f * viewModel.arcValue.value,
                    useCenter = false,
                    size = Size(
                        viewModel.arcSize.value.width.toFloat(),
                        viewModel.arcSize.value.height.toFloat()
                    ),
                    style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
                )
            }

            Text(
                text = viewModel.getLongToTimeStamp(),
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD7E0FF)
            )
        }
    }
}