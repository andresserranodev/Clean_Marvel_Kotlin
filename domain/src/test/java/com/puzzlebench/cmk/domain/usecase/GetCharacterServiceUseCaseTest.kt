package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.service.CharacterServices
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class GetCharacterServiceUseCaseTest {

    private lateinit var characterServiceImp: CharacterServices

    @Before
    fun setUp() {
        val characterList = listOf(1..5).map {
            Mockito.mock(Character::class.java)
        }
        val observable = Single.just(characterList)
        characterServiceImp = mock(CharacterServices::class.java)
        `when`(characterServiceImp.getCharacters()).thenReturn(observable)

    }

    @Test
    operator fun invoke() {
        val getCharacterServiceUseCase = GetCharacterServiceUseCase(characterServiceImp)
        getCharacterServiceUseCase.invoke()
        verify(characterServiceImp).getCharacters()
    }

}