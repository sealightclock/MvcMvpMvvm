package com.example.jonathan.mvcmvpmvvm.mvc

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MvcController(private val model: MvcModel) {
    var displayedText by mutableStateOf("")
        private set

    fun onButtonClick() {
        displayedText = model.mvcText
    }
}