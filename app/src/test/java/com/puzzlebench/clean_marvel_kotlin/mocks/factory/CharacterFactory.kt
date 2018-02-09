package com.puzzlebench.clean_marvel_kotlin.mocks.factory

import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.domain.model.Thumbnail


class CharactersFactory {

    companion object Factory {
        private val BASE_NAME = "Name"
        private val BASE_DESCRIPTION = "Description"
        private val BASE_PATH = "image"
        private val BASE_EXTENSION = ".png"

        open fun getMockCharacter(): List<Character> {
            return (1..5).map {
                Character("$BASE_NAME$it", "$BASE_DESCRIPTION$it", Thumbnail("$BASE_PATH$it", BASE_EXTENSION))
            }
        }
    }
}
