package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.puzzlebench.clean_marvel_kotlin.presentation.base.Presenter
import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.usecase.GetCharacterRepositoryUseCase
import com.puzzlebench.cmk.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.cmk.domain.usecase.SaveCharacterRepositoryUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharacterPresenter constructor(view: CharacterView,
                                     private val getCharacterServiceUseCase: GetCharacterServiceUseCase,
                                     private val getCharacterRepositoryUseCase: GetCharacterRepositoryUseCase,
                                     private val saveCharacterRepositoryUseCase: SaveCharacterRepositoryUseCase,
                                     private val subscriptions: CompositeDisposable) : Presenter<CharacterView>(view) {

    lateinit var marvelCards: List<MarvelCard>
    fun init() {
        view.init()
        marvelCards = getCharacterRepositoryUseCase.invoke()
        if (marvelCards.isEmpty()) {
            requestGetCharacters()
        } else {
            view.hideLoading()
            view.showCharacters(marvelCards)
        }
    }

    private fun requestGetCharacters() {
        val subscription = getCharacterServiceUseCase.invoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ characters ->
            if (characters.isEmpty()) {
                view.showToastNoItemToShow()
            } else {
                saveCharacterRepositoryUseCase.invoke(characters)
                view.showCharacters(characters)
            }
            view.hideLoading()

        }, { e ->
            view.hideLoading()
            view.showToastNetworkError(e.message.toString())
        })
        subscriptions.add(subscription)
    }
}
