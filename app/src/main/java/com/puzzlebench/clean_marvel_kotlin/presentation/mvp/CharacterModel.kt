package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.model.Thumbnail
import javax.inject.Inject

class CharacterModel @Inject constructor() : CharacterContract.Model {

    override fun fetchData(): List<Character> = CharactersFactory.getMockListCharacter()

}

class CharactersFactory {

    companion object Factory {
        const val BASE_NAME = "Name"
        const val BASE_DESCRIPTION = "Description"
        const val BASE_PATH = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784"
        const val BASE_EXTENSION = ".png"

        fun getMockListCharacter(): List<Character> = (1..5).map {
            Character("${BASE_NAME}$it", "${BASE_DESCRIPTION}$it", Thumbnail(BASE_PATH, BASE_EXTENSION))
        }
    }
}