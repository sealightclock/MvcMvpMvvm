package com.example.jonathan.mvcmvpmvvm.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MvvmViewModel : ViewModel() {
    var buttonText by mutableStateOf("")
        private set

    fun onButtonClick(text: String) {
        buttonText = text
    }
}
