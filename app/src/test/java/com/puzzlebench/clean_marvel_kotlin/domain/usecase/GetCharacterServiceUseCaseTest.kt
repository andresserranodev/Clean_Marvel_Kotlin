package com.puzzlebench.clean_marvel_kotlin.domain.usecase

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.puzzlebench.clean_marvel_kotlin.data.service.CharacterServicesImpl
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class GetCharacterServiceUseCaseTest {

    private lateinit var characterServiceImp: CharacterServicesImpl

    @Before
    fun setUp() {
        characterServiceImp = mock()
    }

    @Test
    operator fun invoke() {
        val getCharacterServiceUseCase = GetCharacterServiceUseCase(characterServiceImp)
        getCharacterServiceUseCase.invoke()
        verify(characterServiceImp).getCaracters()
    }

}