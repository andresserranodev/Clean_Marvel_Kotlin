package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.service.CharacterServices
import io.reactivex.Observable

open class GetCharacterServiceUseCase(private val characterServiceImp: CharacterServices) {

   open operator fun invoke(): Observable<List<Character>> = characterServiceImp.getCharacters()
}