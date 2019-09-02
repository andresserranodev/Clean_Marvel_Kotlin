package com.puzzlebench.cmk.domain.usecase


import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.puzzlebench.cmk.data.mocks.factory.CharactersFactory
import com.puzzlebench.cmk.domain.cache.CharacterCache
import com.puzzlebench.cmk.domain.service.CharacterServices
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class FetchCharacterUseCaseTest {

    private lateinit var useCase: FetchCharacterUseCase
    private var characterServices = mock<CharacterServices>()
    private var characterRepository = mock<CharacterCache>()

    @Before
    fun setUp() {
        useCase = FetchCharacterUseCase(characterServices, characterRepository)
    }

    @Test
    fun `return data from cache`() {
        whenever(characterRepository.getAll()).doReturn(CharactersFactory.getMockListCharacter())
        useCase.invoke()
        verify(characterRepository).getAll()
    }

    @Test
    fun `return data from server`() {
        val serviceResponse = CharactersFactory.getMockListCharacter()
        whenever(characterServices.getCharacters()).doReturn(Single.just(serviceResponse))
        whenever(characterRepository.save(serviceResponse)).doReturn(Completable.complete())
        useCase.invoke()
                .test()
                .assertValue(serviceResponse)
        verify(characterRepository).getAll()
        verify(characterServices).getCharacters()
        verify(characterRepository).save(serviceResponse)
    }

}