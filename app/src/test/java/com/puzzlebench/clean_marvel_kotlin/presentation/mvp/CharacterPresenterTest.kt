package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.puzzlebench.clean_marvel_kotlin.data.service.CharacterServicesImpl
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.domain.model.Thumbnail
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterServiceUseCase
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito


class CharacterPresenterTest internal constructor() {

    private val BASE_NAME = "Name"
    private val BASE_DESCRIPTION = "Description"
    private val BASE_PATH = "image"
    private val BASE_EXTENSION = ".png"


    private lateinit var characterPresenter: CharacterPresenter
    private lateinit var view: CharacterView
    private lateinit var getCharacterServiceUseCase: GetCharacterServiceUseCase
    private lateinit var characterServiceImp: CharacterServicesImpl

    @Before
    fun setUp() {

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }

        view = mock()
        val videoItems = (1..5).map {
            Character("$BASE_NAME$it", "$BASE_DESCRIPTION$it", Thumbnail("$BASE_PATH$it", BASE_EXTENSION))
        }
        val observable = Observable.just(videoItems)
        characterServiceImp = mock()
        getCharacterServiceUseCase = GetCharacterServiceUseCase(characterServiceImp)

        val subscriptions = CompositeDisposable()
        characterPresenter = CharacterPresenter(view, getCharacterServiceUseCase, subscriptions)
        Mockito.`when`(getCharacterServiceUseCase.invoke()).thenReturn(observable)


    }

    @Test
    fun getSubscriptions() {
        characterPresenter.int()
        verify(characterServiceImp).getCaracters()
    }
}