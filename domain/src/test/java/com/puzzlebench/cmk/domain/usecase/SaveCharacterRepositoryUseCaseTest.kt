package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.repository.CharacterRepository
import org.junit.*
import org.junit.Assert.*
import org.mockito.Mockito

class SaveCharacterRepositoryUseCaseTest {

    private lateinit var useCase: SaveCharacterRepositoryUseCase

    private lateinit var characterDataRepository: CharacterRepository

    @Before
    fun setUp() {
        characterDataRepository = Mockito.mock(CharacterRepository::class.java)
        useCase = SaveCharacterRepositoryUseCase(characterDataRepository)

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