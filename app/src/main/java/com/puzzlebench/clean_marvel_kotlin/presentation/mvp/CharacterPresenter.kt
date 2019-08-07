package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import io.reactivex.disposables.Disposable
import javax.inject.Inject

class CharacterPresenter @Inject constructor(private val view: CharacterContract.View,
                                             private val model: CharacterContract.Model)
    : CharacterContract.Presenter {

    private var subscription: Disposable? = null

    override fun initPresenter() {
        view.initView()
        fetchData()
    }

    override fun fetchData() {
        subscription = model
                .fetchData()
                .subscribe({ characters ->
                    if (characters.isEmpty()) {
                        view.showMessageNoItemToShow()
                    } else {
                        view.showCharacters(characters)
                    }
                    view.hideLoading()

                }, { e ->
                    view.hideLoading()
                    view.showNetworkError(e.message.toString())
                })
    }

    override fun onPause() {
        subscription?.dispose()
    }
}