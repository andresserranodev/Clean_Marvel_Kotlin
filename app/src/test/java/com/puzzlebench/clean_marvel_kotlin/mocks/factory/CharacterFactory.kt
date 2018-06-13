package com.puzzlebench.clean_marvel_kotlin.mocks.factory

import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.domain.model.Thumbnail


class CharactersFactory {

    companion object Factory {
        const val BASE_NAME = "Name"
        const val BASE_DESCRIPTION = "Description"
        const val BASE_PATH = "image"
        const val BASE_EXTENSION = ".png"

        fun getMockListCharacter(): List<Character> {
            return listOf(1..5).map {
                Character("$BASE_NAME$it", "$BASE_DESCRIPTION$it", Thumbnail("$BASE_PATH$it", BASE_EXTENSION))
            }
        }

        fun getMockCharacter(): Character {
            return Character(BASE_NAME, BASE_DESCRIPTION, Thumbnail(BASE_PATH, BASE_EXTENSION))
        }


    }
}
