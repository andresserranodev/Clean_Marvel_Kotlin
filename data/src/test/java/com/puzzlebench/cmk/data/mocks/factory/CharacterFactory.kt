package com.puzzlebench.cmk.data.mocks.factory

import com.puzzlebench.cmk.data.model.CharacterRealm
import com.puzzlebench.cmk.data.model.ThumbnailRealm
import com.puzzlebench.cmk.data.service.response.CharacterResponse
import com.puzzlebench.cmk.data.service.baseresponse.DataBaseResponse
import com.puzzlebench.cmk.data.service.baseresponse.MarvelBaseResponse
import com.puzzlebench.cmk.data.service.response.ThumbnailResponse
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.model.Thumbnail


class CharactersFactory {

    companion object Factory {
        const val BASE_NAME = "Name"
        const val BASE_DESCRIPTION = "Description"
        const val BASE_PATH = "image"
        const val BASE_EXTENSION = ".png"

        fun getMockListCharacter(): List<Character> = (1..5).map {
            Character("${BASE_NAME}$it", "${BASE_DESCRIPTION}$it", Thumbnail("${BASE_PATH}$it", BASE_EXTENSION))
        }

        fun getMockCharacter() = Character(BASE_NAME, BASE_DESCRIPTION, Thumbnail(BASE_PATH, BASE_EXTENSION))

        fun getMockListCharacterResponse(): List<CharacterResponse> = (1..5).map {
            CharacterResponse("${BASE_NAME}$it", "${BASE_DESCRIPTION}$it", ThumbnailResponse("${BASE_PATH}$it", BASE_EXTENSION))
        }

        fun getMockDataBaseResponse() = DataBaseResponse(1, 1, 1, getMockListCharacterResponse())

        fun getMockDataMarvelBaseResponse() = MarvelBaseResponse(1, "Status", getMockDataBaseResponse())

        fun getMockListCharacterRealm(): List<CharacterRealm> = (1..5).map {
            CharacterRealm("${BASE_NAME}$it", "${BASE_DESCRIPTION}$it", ThumbnailRealm("${BASE_PATH}$it", BASE_EXTENSION))
        }
    }
}


