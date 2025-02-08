package com.example.jonathan.mvcmvpmvvm.mvp

interface MainView {
    fun showText(text: String)
}

class MvpPresenter(private val view: MainView) {
    private val model = MvpModel()

    fun onButtonClicked() {
        view.showText(model.label)
    }
}
