package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.repository.CharacterRepository

class SaveCharacterRepositoryUseCase constructor(private val characterDataRepository: CharacterRepository) {
    operator fun invoke(marvelCards: List<MarvelCard>) = characterDataRepository.save(marvelCards)
}