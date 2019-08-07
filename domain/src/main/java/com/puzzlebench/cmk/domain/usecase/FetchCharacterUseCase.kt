package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.repository.CharacterRepository
import com.puzzlebench.cmk.domain.service.CharacterServices
import io.reactivex.Single
import javax.inject.Inject

class FetchCharacterUseCase @Inject constructor(private val characterServiceImp: CharacterServices,
                                                private val characterDataRepository: CharacterRepository) {

    operator fun invoke(): Single<List<Character>> {
        val characterRepositoryData = characterDataRepository.getAll()
        return if (characterRepositoryData.isEmpty()) {
            characterServiceImp
                    .getCharacters()
                    .flatMap { characters ->
                        characterDataRepository
                                .save(characters)
                                .andThen(Single.just(characters))
                    }
        } else {
            Single.just(characterRepositoryData)
        }

    }
}