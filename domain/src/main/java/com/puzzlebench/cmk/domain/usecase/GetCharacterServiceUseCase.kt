package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.service.CharacterServices
import io.reactivex.Single

class GetCharacterServiceUseCase constructor(private val characterServiceImp: CharacterServices):BaseServiceUseCase {

    override fun invoke(): Single<List<MarvelCard>> = characterServiceImp.getCharacters()
}