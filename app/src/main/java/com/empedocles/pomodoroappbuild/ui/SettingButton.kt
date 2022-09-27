package com.empedocles.pomodoroappbuild.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.empedocles.pomodoroappbuild.R

@Composable
fun SettingsButton(context : Context){
    Image(
        painterResource(id = R.drawable.ic_settings),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(bottom = 48.dp)
            .clickable(enabled = true, onClick = {
                Toast
                    .makeText(context, "Coming soon", Toast.LENGTH_SHORT)
                    .show()
            })
    )
}