package com.empedocles.pomodoroappbuild.util

fun Long.timeStamp(): String{
    val seconds = (this / 1000) % 60;
    val minutes = (this / (1000 * 60)) % 60;

    return "$this milisecond = $minutes minutes and $seconds seconds."
}