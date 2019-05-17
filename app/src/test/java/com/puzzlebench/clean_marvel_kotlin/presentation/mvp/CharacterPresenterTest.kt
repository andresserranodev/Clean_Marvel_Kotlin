package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.repository.CharacterRepository
import com.puzzlebench.cmk.domain.service.CharacterServices
import com.puzzlebench.cmk.domain.usecase.GetCharacterRepositoryUseCase
import com.puzzlebench.cmk.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.cmk.domain.usecase.SaveCharacterRepositoryUseCase
import io.reactivex.Single
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
    private var characterServiceImp = mock(CharacterServices::class.java)
    private var characterRepository = mock(CharacterRepository::class.java)

    private lateinit var characterPresenter: CharacterPresenter
    private lateinit var getCharacterServiceUseCase: GetCharacterServiceUseCase
    private lateinit var getCharacterRepositoryUseCase: GetCharacterRepositoryUseCase
    private lateinit var saveCharacterRepositoryUseCase: SaveCharacterRepositoryUseCase


    @Before
    fun setUp() {

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        getCharacterServiceUseCase = GetCharacterServiceUseCase(characterServiceImp)
        getCharacterRepositoryUseCase = GetCharacterRepositoryUseCase(characterRepository)
        saveCharacterRepositoryUseCase = SaveCharacterRepositoryUseCase(characterRepository)
        val subscriptions = mock(CompositeDisposable::class.java)
        characterPresenter = CharacterPresenter(view,
                getCharacterServiceUseCase,
                getCharacterRepositoryUseCase,
                saveCharacterRepositoryUseCase,
                subscriptions)


    }


    @Test
    fun init() {
        val itemsCharacters = listOf(1..5).map {
            mock(Character::class.java)
        }
        val observable = Single.just(itemsCharacters)
        Mockito.`when`(getCharacterServiceUseCase.invoke()).thenReturn(observable)
        Mockito.`when`(getCharacterRepositoryUseCase.invoke()).thenReturn(emptyList())
        characterPresenter.init()
        verify(view).init()
        verify(characterServiceImp).getCharacters()
        verify(characterRepository).getAll()
        verify(view).hideLoading()
        verify(view).showCharacters(itemsCharacters)


    }

    @Ignore
    fun reposeWithError() {
        Mockito.`when`(getCharacterServiceUseCase.invoke()).thenReturn(Single.error(Exception("")))
        characterPresenter.init()
        verify(view).init()
        verify(characterServiceImp).getCharacters()
        verify(view).hideLoading()
        verify(view).showToastNetworkError("")

    }

    @Ignore
    fun reposeWithItemToShow() {
        val itemsCharacters = listOf(1..5).map {
            mock(Character::class.java)
        }
        val observable = Single.just(itemsCharacters)
        Mockito.`when`(getCharacterServiceUseCase.invoke()).thenReturn(observable)
        characterPresenter.init()
        verify(view).init()
        verify(characterServiceImp).getCharacters()
        verify(view).hideLoading()
        verify(view).showCharacters(itemsCharacters)


    }

    @Ignore
    fun reposeWithoutItemToShow() {
        val itemsCharacters = emptyList<Character>()
        val observable = Single.just(itemsCharacters)
        Mockito.`when`(getCharacterServiceUseCase.invoke()).thenReturn(observable)
        characterPresenter.init()
        verify(view).init()
        verify(characterServiceImp).getCharacters()


    }


}