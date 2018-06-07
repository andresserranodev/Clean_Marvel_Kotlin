package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterRepositoryUseCase
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.presentation.base.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CharacterPresenter(view: CharacterView,
                         private val getChatacterServiceUseCase: GetCharacterServiceUseCase,
                         private val getCharacterRepositoryUseCase: GetCharacterRepositoryUseCase, val subscriptions: CompositeDisposable) : Presenter<CharacterView>(view) {

    lateinit var characters: List<Character>
    fun init() {
        view.init()
        characters = getCharacterRepositoryUseCase.invoke()
        if (characters.isEmpty()) {
            requestGetCharacters()
        } else {
            view.hideLoading()
            view.showCharacters(characters)
        }
    }

    private fun requestGetCharacters() {

        val subscription = getChatacterServiceUseCase.invoke().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ characters ->
            if (characters.isEmpty()) {
                view.showToastNoItemToShow()
            } else {
                getCharacterRepositoryUseCase.invoke(characters)
                view.showCharacters(characters)
            }
            view.hideLoading()

        }, { e ->
            view.hideLoading()
            view.showToastNetworkError(e.message.toString())
        })
        subscriptions.add(subscription)
    }

    inner class CharecterSubscriber : DisposableSingleObserver<List<Character>>() {

        override fun onSuccess(t: List<Character>) {
            view.showCharacters(t)
        }

        override fun onError(exception: Throwable) {
            view.hideLoading()
            view.showToastNetworkError(exception.message.toString())
        }

    }
}
