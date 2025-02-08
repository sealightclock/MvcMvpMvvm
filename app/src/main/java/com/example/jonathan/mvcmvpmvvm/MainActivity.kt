package com.example.jonathan.mvcmvpmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.jonathan.mvcmvpmvvm.mvc.MvcController
import com.example.jonathan.mvcmvpmvvm.mvc.MvcModel
import com.example.jonathan.mvcmvpmvvm.mvp.MainView
import com.example.jonathan.mvcmvpmvvm.mvp.MvpPresenter
import com.example.jonathan.mvcmvpmvvm.mvvm.MvvmViewModel
import com.example.jonathan.mvcmvpmvvm.view.MainApp

class MainActivity : ComponentActivity(), MainView {
    // MVC
    private val mvcModel = MvcModel()
    private val mvcController = MvcController(mvcModel)

    // MVP
    private lateinit var mvpPresenter: MvpPresenter
    private var mvpText by mutableStateOf("")

    // MVVM
    private var mvvmViewModel = MvvmViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mvpPresenter = MvpPresenter(this)

        setContent {
            MainApp(
                mvcController,
                mvpPresenter,
                mvpText,
                mvvmViewModel
            )
        }
    }

    override fun showMvpText(text: String) {
        mvpText = text
        setContent {
            MainApp(
                mvcController,
                mvpPresenter,
                mvpText,
                mvvmViewModel
            )
        }
    }
}
