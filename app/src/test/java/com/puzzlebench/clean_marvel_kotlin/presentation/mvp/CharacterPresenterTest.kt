package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.puzzlebench.clean_marvel_kotlin.data.repository.CharacterRepository
import com.puzzlebench.clean_marvel_kotlin.data.service.CharacterServicesImpl
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterRepositoryUseCase
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.mocks.factory.CharactersFactory
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

//TODO fix on second iteration
// error: However, there was exactly 1 interaction with this mock:
class CharacterPresenterTest {

    private var view = mock(CharacterView::class.java)
    private var characterServiceImp = mock(CharacterServicesImpl::class.java)
    private var characterRepository = mock(CharacterRepository::class.java)

    private lateinit var characterPresenter: CharacterPresenter
    private lateinit var getCharacterServiceUseCase: GetCharacterServiceUseCase
    private lateinit var getCharacterRepositoryUseCase: GetCharacterRepositoryUseCase


    @Before
    fun setUp() {

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }

        getCharacterServiceUseCase = GetCharacterServiceUseCase(characterServiceImp)
        getCharacterRepositoryUseCase = GetCharacterRepositoryUseCase(characterRepository)
        val subscriptions = mock(CompositeDisposable::class.java)
        characterPresenter = CharacterPresenter(view, getCharacterServiceUseCase, getCharacterRepositoryUseCase, subscriptions)


    }



    @Test
    fun init() {
        val itemsCharecters = CharactersFactory.getMockListCharacter()
        val observable = Observable.just(itemsCharecters)
        Mockito.`when`(getCharacterServiceUseCase.invoke()).thenReturn(observable)
        Mockito.`when`(getCharacterRepositoryUseCase.invoke()).thenReturn(emptyList())
        characterPresenter.init()
        verify(view).init()
        verify(characterServiceImp).getCaracters()
        verify(characterRepository).getAll()
        verify(view).hideLoading()
        verify(view).showCharacters(itemsCharecters)


    }
    @Ignore
    fun reposeWithError() {
        Mockito.`when`(getCharacterServiceUseCase.invoke()).thenReturn(Observable.error(Exception("")))
        characterPresenter.init()
        verify(view).init()
        verify(characterServiceImp).getCaracters()
        verify(view).hideLoading()
        verify(view).showToastNetworkError("")

    }

    @Ignore
    fun reposeWithItemToShow() {
        val itemsCharecters = CharactersFactory.getMockListCharacter()
        val observable = Observable.just(itemsCharecters)
        Mockito.`when`(getCharacterServiceUseCase.invoke()).thenReturn(observable)
        characterPresenter.init()
        verify(view).init()
        verify(characterServiceImp).getCaracters()
        verify(view).hideLoading()
        verify(view).showCharacters(itemsCharecters)


    }

    @Ignore
    fun reposeWithoutItemToShow() {
        val itemsCharecters = emptyList<Character>()
        val observable = Observable.just(itemsCharecters)
        Mockito.`when`(getCharacterServiceUseCase.invoke()).thenReturn(observable)
        characterPresenter.init()
        verify(view).init()
        verify(characterServiceImp).getCaracters()


    }


}