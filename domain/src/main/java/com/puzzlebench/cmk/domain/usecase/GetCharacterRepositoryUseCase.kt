package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.repository.CharacterRepository


class GetCharacterRepositoryUseCase constructor(private val characterDataRepository: CharacterRepository) {

    operator fun invoke(): List<MarvelCard> = characterDataRepository.getAll()

}