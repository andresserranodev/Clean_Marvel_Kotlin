package com.puzzlebench.clean_marvel_kotlin.domain.usecase

import com.puzzlebench.clean_marvel_kotlin.data.repository.CharacterRepository
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character


class GetCharacterRepositoryUseCase(private val characterRepository: CharacterRepository) {

    operator fun invoke(): List<Character> = characterRepository.getAll()
    operator fun invoke(character: List<Character>) = characterRepository.save(character)

}