package com.example.jonathan.mvcmvpmvvm.mvp

interface MainView {
    fun showMvpText(text: String)
}

class MvpPresenter(private val view: MainView) {
    private val mvpModel = MvpModel()

    var mvpText: String = ""

    fun onMvpButtonClicked() {
        mvpText = mvpModel.mvpText
        view.showMvpText(mvpText)
    }
}
