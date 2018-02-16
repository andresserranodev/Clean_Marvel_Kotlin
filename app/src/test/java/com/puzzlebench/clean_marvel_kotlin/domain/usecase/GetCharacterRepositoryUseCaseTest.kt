package com.puzzlebench.clean_marvel_kotlin.domain.usecase

import com.puzzlebench.clean_marvel_kotlin.data.repository.CharacterRepository
import com.puzzlebench.clean_marvel_kotlin.mocks.factory.CharactersFactory
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetCharacterRepositoryUseCaseTest {

    private lateinit var useCase: GetCharacterRepositoryUseCase

    private lateinit var charecterRepository: CharacterRepository

    @Before
    fun setUp() {
        charecterRepository = Mockito.mock(CharacterRepository::class.java)
        useCase = GetCharacterRepositoryUseCase(charecterRepository)

    }

    @Test
    fun invokeGetAll() {
        useCase.invoke()
        Mockito.verify(charecterRepository).getAll()

    }

    @Test
    fun invokeSave() {
        val characterList = CharactersFactory.getMockListCharacter()
        useCase.invoke(characterList)
        Mockito.verify(charecterRepository).save(characterList)
    }

}