package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.cache.CharacterCache
import com.puzzlebench.cmk.domain.service.CharacterServices
import io.reactivex.Single
import javax.inject.Inject

class FetchCharacterUseCase @Inject constructor(private val characterServiceImp: CharacterServices,
                                                private val characterDataCache: CharacterCache) {

    operator fun invoke(): Single<List<Character>> {
        val characterRepositoryData = characterDataCache.getAll()
        return if (characterRepositoryData.isEmpty()) {
            characterServiceImp
                    .getCharacters()
                    .flatMap { characters ->
                        characterDataCache
                                .save(characters)
                                .andThen(Single.just(characters))
                    }
        } else {
            Single.just(characterRepositoryData)
        }

    }
}