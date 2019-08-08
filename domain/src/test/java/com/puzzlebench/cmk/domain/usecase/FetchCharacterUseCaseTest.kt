package com.puzzlebench.cmk.domain.usecase


import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.puzzlebench.cmk.data.mocks.factory.CharactersFactory
import com.puzzlebench.cmk.domain.repository.CharacterRepository
import com.puzzlebench.cmk.domain.service.CharacterServices
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class FetchCharacterUseCaseTest {

    private lateinit var useCase: FetchCharacterUseCase
    private var characterServices = mock<CharacterServices>()
    private var characterRepository = mock<CharacterRepository>()

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
        useCase.invoke()
        verify(characterRepository).getAll()
        verify(characterServices).getCharacters()
        //TODO check how to verify if the single execute in  flatMap the verify(characterRepository).save(serviceResponse)
    }

}