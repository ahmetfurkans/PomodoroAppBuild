package com.empedocles.pomodoroappbuild.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.empedocles.pomodoroappbuild.util.MinuteConstants
import com.empedocles.pomodoroappbuild.util.TimeStringConstants
import com.empedocles.pomodoroappbuild.util.timeStamp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel() {
    var totalTime = mutableStateOf(45 * 60L * 1000L)
    var currentTime = mutableStateOf(totalTime.value)
    var selectedTimeMethod = mutableStateOf(TimeStringConstants.POMODORO)
    var isTimerRunning = mutableStateOf(false)

    fun runTimer() {
        viewModelScope.launch {
            while (isTimerRunning.value && currentTime.value >= 0) {
                currentTime.value -= 100L
                delay(100L)
            }
        }
    }

    fun startStop(){
        isTimerRunning.value = !isTimerRunning.value
        if(isTimerRunning.value){
            runTimer()
        }
    }

    fun getLongToTimeStamp() : String{
        return currentTime.value.timeStamp()
    }

    fun changeTimeMethod(timeMethod: String){
        isTimerRunning.value = false
        selectedTimeMethod.value = timeMethod

        when(selectedTimeMethod.value){
            TimeStringConstants.POMODORO -> totalTime.value = MinuteConstants.POMODORO_MINUTE
            TimeStringConstants.LONG_BREAK -> totalTime.value = MinuteConstants.LONG_BREAK_MINUTE
            TimeStringConstants.SHORT_BREAK -> totalTime.value = MinuteConstants.SHORT_BREAK_MINUTE
        }
        currentTime.value = totalTime.value
    }
}