package com.example.jonathan.mvcmvpmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jonathan.mvcmvpmvvm.mvc.MvcController
import com.example.jonathan.mvcmvpmvvm.mvc.MvcModel
import com.example.jonathan.mvcmvpmvvm.view.MainApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mvcModel = MvcModel()
            val mvcController = MvcController(mvcModel)

            MainApp(mvcController)
        }
    }
}
