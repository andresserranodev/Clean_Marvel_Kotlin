package com.puzzlebench.cmk.data.mapper.service

import com.puzzlebench.cmk.data.mocks.factory.CharactersFactory
import com.puzzlebench.cmk.data.service.response.CharacterResponse
import com.puzzlebench.cmk.data.service.response.ThumbnailResponse
import com.puzzlebench.cmk.domain.model.MarvelCard
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class MarvelCardMapperServiceTest {
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
    fun transformToResponse() {
        val mockCharacter = CharactersFactory.getMockCharacter()
        val result = mapper.transformToResponse(mockCharacter)
        assertBufferooDataEquality(result, mockCharacter)

    }

    private fun assertBufferooDataEquality(characterResponse: CharacterResponse, marvelCard: MarvelCard) {
        Assert.assertEquals(characterResponse.name, marvelCard.header)
        Assert.assertEquals(characterResponse.description, marvelCard.description)
        Assert.assertEquals(characterResponse.thumbnail.path, marvelCard.thumbnail.path)
        Assert.assertEquals(characterResponse.thumbnail.extension, marvelCard.thumbnail.extension)


    }

}