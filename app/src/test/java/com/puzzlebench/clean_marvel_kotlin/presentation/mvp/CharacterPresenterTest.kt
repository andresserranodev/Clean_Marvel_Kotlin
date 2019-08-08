package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.puzzlebench.cmk.data.mocks.factory.CharactersFactory
import com.puzzlebench.cmk.domain.model.Character
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.junit.*
import org.junit.Assert.*

class CharacterPresenterTest {

    private lateinit var presenter: CharacterPresenter
    private var characterView = mock<CharacterView>()
    private var characterModel = mock<CharacterModel>()

    @Before
    fun setUp() {
        presenter = CharacterPresenter(characterView, characterModel)
        val characters = CharactersFactory.getMockListCharacter()
        whenever(characterModel.fetchData()).doReturn(Single.just(characters))
    }

    @Test
    fun initPresenter() {
        presenter.initPresenter()
        verify(characterView).initView()
    }

    @Test
    fun `show items`() {
        val characters = CharactersFactory.getMockListCharacter()
        whenever(characterModel.fetchData()).doReturn(Single.just(characters))
        presenter.fetchData()
        verify(characterModel).fetchData()
        verify(characterView).showCharacters(characters)
        verify(characterView).hideLoading()

    }

    @Test
    fun `no items to show`() {
        val noCharacter = listOf<Character>()
        whenever(characterModel.fetchData()).doReturn(Single.just(noCharacter))
        presenter.fetchData()
        verify(characterModel).fetchData()
        verify(characterView).showMessageNoItemToShow()
        verify(characterView).hideLoading()

    }

    @Test
    fun `error getting data`() {
        val errorMessage = "mock Error Messages"
        whenever(characterModel.fetchData()).doReturn(Single.error(Exception(errorMessage)))
        presenter.fetchData()
        verify(characterModel).fetchData()
        verify(characterView).showNetworkError(errorMessage)
        verify(characterView).hideLoading()

    }

    @Test
    fun onPause() {
        presenter.onPause()

    }
}