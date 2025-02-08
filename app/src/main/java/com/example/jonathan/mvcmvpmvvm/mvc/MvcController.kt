package com.example.jonathan.mvcmvpmvvm.mvc

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MvcController(private val mvcModel: MvcModel) {
    var mvcText by mutableStateOf("")
        private set

    fun onMvcButtonClick() {
        mvcText = mvcModel.mvcText
    }
}
