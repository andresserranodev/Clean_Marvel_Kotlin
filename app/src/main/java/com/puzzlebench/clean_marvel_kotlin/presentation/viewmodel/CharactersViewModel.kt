package com.puzzlebench.clean_marvel_kotlin.presentation.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.usecase.BaseServiceUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharactersViewModel(private val useCase: BaseServiceUseCase) : ViewModel() {


    private lateinit var _charactersViewState: MutableLiveData<ScreenState<CharactersViewState>>
    private var subscriptions = CompositeDisposable()


    val mainState: LiveData<ScreenState<CharactersViewState>>
        get() {
            if (!::_charactersViewState.isInitialized) {
                _charactersViewState = MutableLiveData()
                _charactersViewState.value = ScreenState.Loading
                val subscription = useCase.invoke()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ characters ->
                            onItemsLoaded(characters)
                        }, { error ->
                            showError(error.message.toString())
                        })
                subscriptions.add(subscription)
            }
            return _charactersViewState
        }

    private fun onItemsLoaded(items: List<MarvelCard>) {
        _charactersViewState.value = ScreenState.Render(CharactersViewState.ShowItems(items))
    }

    private fun showError(message: String) {
        _charactersViewState.value = ScreenState.Render(CharactersViewState.ShowMessage(message))
    }

    override fun onCleared() {
        subscriptions.dispose()
        super.onCleared()
    }
}

@Suppress("UNCHECKED_CAST")
class CharactersViewModelFactory(private val useCase: BaseServiceUseCase) :
        ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CharactersViewModel(useCase) as T
    }
}