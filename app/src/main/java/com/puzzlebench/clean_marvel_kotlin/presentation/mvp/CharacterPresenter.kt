package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.presentation.weak
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharacterPresenter(
        view: CharacterView,
        private val getChatacterServiceUseCase: GetCharacterServiceUseCase,
        val subscriptions: CompositeDisposable) {
    private val view: CharacterView? by weak(view)

    fun int() {
        requestGetCharacters()
    }

    private fun requestGetCharacters() {
        val subscription = getChatacterServiceUseCase.invoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { characters ->
                            view?.hideLoading()
                            view?.showCharacters(characters)
                        },
                        { e ->
                            view?.hideLoading()
                            view?.showToastNetworkError(e.message.toString())
                        }
                )
        subscriptions.add(subscription)
    }
}
