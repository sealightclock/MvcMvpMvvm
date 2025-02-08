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
import androidx.compose.ui.unit.sp
import com.example.jonathan.mvcmvpmvvm.mvc.MvcController

@Composable
fun MainApp(mvcController: MvcController) {
    var selectedArchitecture by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Select an Architecture Pattern:", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        MvcButton(mvcController)
        SpecialButton("MVP") { selectedArchitecture = "MVP" }
        SpecialButton("MVVM") { selectedArchitecture = "MVVM" }

        Spacer(modifier = Modifier.height(24.dp))

        if (selectedArchitecture.isNotEmpty()) {
            Text(text = "Data taken via $selectedArchitecture", fontSize = 24.sp)
        }
    }
}

@Composable
fun SpecialButton(label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = label)
    }
}

@Composable
fun MvcButton(mvcController: MvcController) {
    Button(
        onClick = { mvcController.onButtonClick() },
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "MVC")
    }

    if (mvcController.displayedText.isNotEmpty()) {
        Text(text = mvcController.displayedText)
    }
}
