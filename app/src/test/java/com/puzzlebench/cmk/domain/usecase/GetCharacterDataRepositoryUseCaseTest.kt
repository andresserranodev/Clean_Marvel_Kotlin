package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.clean_marvel_kotlin.data.repository.CharacterDataRepository
import com.puzzlebench.clean_marvel_kotlin.mocks.factory.CharactersFactory
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetCharacterDataRepositoryUseCaseTest {

    private lateinit var useCase: GetCharacterRepositoryUseCase

    private lateinit var characterDataRepository: CharacterDataRepository

    @Before
    fun setUp() {
        characterDataRepository = Mockito.mock(CharacterDataRepository::class.java)
        useCase = GetCharacterRepositoryUseCase(characterDataRepository)

    }

    @Test
    fun invokeGetAll() {
        useCase.invoke()
        Mockito.verify(characterDataRepository).getAll()

    }

    @Test
    fun invokeSave() {
        val characterList = CharactersFactory.getMockListCharacter()
        useCase.invoke(characterList)
        Mockito.verify(characterDataRepository).save(characterList)
    }

}