package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.Character

class FetchCharacterUseCase constructor(private val getCharacterRepositoryUseCase: GetCharacterRepositoryUseCase) {

    operator fun invoke(): List<Character> = getCharacterRepositoryUseCase.invoke()
}