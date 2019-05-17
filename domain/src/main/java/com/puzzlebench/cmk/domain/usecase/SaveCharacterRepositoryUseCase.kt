package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.repository.CharacterRepository

class SaveCharacterRepositoryUseCase constructor(private val characterDataRepository: CharacterRepository) {
    operator fun invoke(characters: List<Character>) = characterDataRepository.save(characters)
}