package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.puzzlebench.clean_marvel_kotlin.data.service.CharacterServicesImpl
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.mocks.factory.CharactersFactory
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class CharacterPresenterTest internal constructor() {


    private lateinit var characterPresenter: CharacterPresenter

    private lateinit var view: CharecterView
    private lateinit var getCharacterServiceUseCase: GetCharacterServiceUseCase
    private lateinit var characterServiceImp: CharacterServicesImpl

    @Before
    fun setUp() {

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }
        view = mock(CharecterView::class.java)
        val videoItems = CharactersFactory.getMockCharacter()
        val observable = Observable.just(videoItems)
        characterServiceImp = mock(CharacterServicesImpl::class.java)
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