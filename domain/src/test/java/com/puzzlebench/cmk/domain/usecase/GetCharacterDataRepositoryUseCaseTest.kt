package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.repository.CharacterRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetCharacterDataRepositoryUseCaseTest {

    private lateinit var useCase: GetCharacterRepositoryUseCase

    private lateinit var characterDataRepository: CharacterRepository

    @Before
    fun setUp() {
        characterDataRepository = Mockito.mock(CharacterRepository::class.java)
        useCase = GetCharacterRepositoryUseCase(characterDataRepository)

    }

    @Test
    fun invokeGetAll() {
        useCase.invoke()
        Mockito.verify(characterDataRepository).getAll()

    }

    @Test
    fun invokeSave() {
        val characterList = listOf(1..5).map {
            Mockito.mock(Character::class.java)
        }
        useCase.invoke(characterList)
        Mockito.verify(characterDataRepository).save(characterList)
    }

}