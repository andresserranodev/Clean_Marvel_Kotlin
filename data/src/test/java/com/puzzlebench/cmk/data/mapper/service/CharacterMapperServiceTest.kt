package com.puzzlebench.cmk.data.mapper.service

import com.puzzlebench.cmk.data.mocks.factory.CharactersFactory
import com.puzzlebench.cmk.data.mocks.factory.CharactersFactory.Factory.getMockListCharacterResponse
import com.puzzlebench.cmk.data.service.response.CharacterResponse
import com.puzzlebench.cmk.data.service.response.ThumbnailResponse
import com.puzzlebench.cmk.domain.model.Character
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class CharacterMapperServiceTest {
    private lateinit var mapper: CharacterMapperService


    @Before
    fun setUp() {
        mapper = CharacterMapperService()

    }

    @Test
    fun transform() {
        val mockThumbnailResponse = ThumbnailResponse(CharactersFactory.BASE_PATH, CharactersFactory.BASE_EXTENSION)
        val mockCharacterResponse = CharacterResponse(CharactersFactory.BASE_NAME, CharactersFactory.BASE_DESCRIPTION, mockThumbnailResponse)
        val result = mapper.transform(mockCharacterResponse)
        assertBufferooDataEquality(mockCharacterResponse, result)
    }

    @Test
    fun transformList() {
        val mockListCharacterResponse = getMockListCharacterResponse()
        val result = mapper.transform(mockListCharacterResponse)
        result.forEachIndexed { index, resultCharacter ->
            assertBufferooDataEquality(mockListCharacterResponse[index], resultCharacter)
        }
    }

    @Test
    fun transformToResponse() {
        val mockCharacter = CharactersFactory.getMockCharacter()
        val result = mapper.transformToResponse(mockCharacter)
        assertBufferooDataEquality(result, mockCharacter)

    }

    private fun assertBufferooDataEquality(characterResponse: CharacterResponse, character: Character) {
        Assert.assertEquals(characterResponse.name, character.name)
        Assert.assertEquals(characterResponse.description, character.description)
        Assert.assertEquals(characterResponse.thumbnail.path, character.thumbnail.path)
        Assert.assertEquals(characterResponse.thumbnail.extension, character.thumbnail.extension)


    }

}