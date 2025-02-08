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
    mvpText: String,
    mvvmViewModel: MvvmViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MvcButton(mvcController)
        MvpButton(mvpPresenter, mvpText)
        MvvmButton(mvvmViewModel)
    }
}

@Composable
fun MvcButton(mvcController: MvcController) {
    Button(
        onClick = { mvcController.onMvcButtonClick() },
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "MVC")
    }

    Spacer(modifier = Modifier.height(16.dp))

    if (mvcController.mvcText.isNotEmpty()) {
        Text(text = mvcController.mvcText)
    }
}

@Composable
fun MvpButton(mvpPresenter: MvpPresenter, mvpText: String) {
    Button(onClick = { mvpPresenter.onMvpButtonClicked() }) {
        Text("MVP")
    }

    Spacer(modifier = Modifier.height(16.dp))

    if (mvpText.isNotEmpty()) {
        Text(text = mvpText)
    }
}

@Composable
fun MvvmButton(mvvmViewModel: MvvmViewModel) {
    Button(onClick = { mvvmViewModel.onMvvmButtonClick() }) {
        Text("MVVM")
    }

    Spacer(modifier = Modifier.height(16.dp))

    if (mvvmViewModel.mvvmText.isNotEmpty()) {
        Text(mvvmViewModel.mvvmText)
    }
}
