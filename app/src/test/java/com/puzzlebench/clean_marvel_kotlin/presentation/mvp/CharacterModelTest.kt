package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.puzzlebench.cmk.data.mocks.factory.CharactersFactory
import com.puzzlebench.cmk.domain.usecase.FetchCharacterUseCase
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.*
import org.junit.Assert.*

class CharacterModelTest {

    lateinit var characterModel: CharacterModel
    var fetchCharacterUseCase = mock<FetchCharacterUseCase>()

    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        val characters = CharactersFactory.getMockListCharacter()
        whenever(fetchCharacterUseCase.invoke()).doReturn(Single.just(characters))
        characterModel = CharacterModel(fetchCharacterUseCase)
    }

    @Test
    fun fetchData() {
        characterModel.fetchData()
        verify(fetchCharacterUseCase).invoke()

    }
}