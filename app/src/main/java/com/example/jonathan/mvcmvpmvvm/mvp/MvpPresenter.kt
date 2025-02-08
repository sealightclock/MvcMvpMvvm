package com.example.jonathan.mvcmvpmvvm.mvp

interface MainView {
    fun showMvpText(text: String)
}

class MvpPresenter(private val view: MainView) {
    private val mvpModel = MvpModel()

    fun onMvpButtonClicked() {
        view.showMvpText(mvpModel.mvpText)
    }
}
