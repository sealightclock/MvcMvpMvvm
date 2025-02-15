package com.example.jonathan.mvcmvpmvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jonathan.mvcmvpmvvm.mvc.MvcController
import com.example.jonathan.mvcmvpmvvm.mvp.MvpPresenter
import com.example.jonathan.mvcmvpmvvm.mvvm.MvvmViewModel

@Composable
fun MainApp(
    mvcController: MvcController,
    mvpPresenter: MvpPresenter,
    mvvmViewModel: MvvmViewModel
) {
    // This approach ensures state hoisting, keeping the source of truth in the parent and allowing
    // child functions to modify it via callbacks.
    var textValue by remember { mutableStateOf("initial text") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MvcButton(mvcController, updateText = { newValue -> textValue = newValue })
        MvpButton(mvpPresenter, updateText = { newValue -> textValue = newValue })
        MvvmButton(mvvmViewModel, updateText = { newValue -> textValue = newValue })

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = textValue)
    }
}

/**
 * In Jetpack Compose, functions are composable and follow a unidirectional data flow (UDF) model,
 * which means that one function cannot directly modify a variable in another function. However,
 * you can achieve this behavior using state hoisting and mutable state variables.
 */
@Composable
fun MvcButton(mvcController: MvcController, updateText: (String) -> Unit) {
    Button(
        onClick = {
            mvcController.onMvcButtonClick()
            updateText(mvcController.mvcText)
                  },
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "MVC")
    }
}


// TODO: 2 clicks are needed:
@Composable
fun MvpButton(mvpPresenter: MvpPresenter, updateText: (String) -> Unit) {
    Button(
        onClick = {
            mvpPresenter.onMvpButtonClicked()
            updateText(mvpPresenter.mvpText)
                  },
        modifier = Modifier.padding(8.dp)
    ) {
        Text("MVP")
    }
}

@Composable
fun MvvmButton(mvvmViewModel: MvvmViewModel, updateText: (String) -> Unit) {
    Button(
        onClick = {
            mvvmViewModel.onMvvmButtonClick()
            updateText(mvvmViewModel.mvvmText)
                  },
        modifier = Modifier.padding(8.dp)
    ) {
        Text("MVVM")
    }
}
