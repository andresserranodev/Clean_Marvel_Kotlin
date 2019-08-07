package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.service.CharacterServices
import io.reactivex.Single
import javax.inject.Inject

class FetchCharacterUseCase @Inject constructor(private val characterServiceImp: CharacterServices) {

    operator fun invoke(): Single<List<Character>> = characterServiceImp.getCharacters()
}