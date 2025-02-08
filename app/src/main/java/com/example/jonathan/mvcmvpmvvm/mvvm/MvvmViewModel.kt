package com.example.jonathan.mvcmvpmvvm.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MvvmViewModel : ViewModel() {
    var mvvmText by mutableStateOf("")
        private set

    fun onMvvmButtonClick(text: String) {
        mvvmText = text
    }
}
