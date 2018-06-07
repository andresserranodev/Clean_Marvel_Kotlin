package com.puzzlebench.clean_marvel_kotlin.domain.usecase

import com.puzzlebench.clean_marvel_kotlin.data.service.CharacterServicesImpl
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import io.reactivex.Single

open class GetCharacterServiceUseCase(private val characterServiceImp: CharacterServicesImpl) {

    open operator fun invoke(): Single<List<Character>> = characterServiceImp.getCaracters()

}