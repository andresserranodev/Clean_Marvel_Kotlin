package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.service.CharacterServices
import io.reactivex.Single

open class GetCharacterServiceUseCase constructor(private val characterServiceImp: CharacterServices) {

    open operator fun invoke(): Single<List<Character>> = characterServiceImp.getCharacters()
}