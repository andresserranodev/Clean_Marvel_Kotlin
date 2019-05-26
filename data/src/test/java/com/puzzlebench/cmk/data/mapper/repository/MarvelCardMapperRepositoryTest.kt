package com.puzzlebench.cmk.data.mapper.repository

import com.puzzlebench.cmk.data.mocks.factory.CharactersFactory
import com.puzzlebench.cmk.data.model.CharacterRealm
import com.puzzlebench.cmk.data.model.ThumbnailRealm
import com.puzzlebench.cmk.domain.model.MarvelCard
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class MarvelCardMapperRepositoryTest {

    private lateinit var mapper: CharacterMapperRepository

    @Before
    fun setUp() {
        mapper = CharacterMapperRepository()

    }

    @Test
    fun transform() {


        val mockThumbnailRealm = ThumbnailRealm(CharactersFactory.BASE_PATH, CharactersFactory.BASE_EXTENSION)
        val mockCharacterRealm = CharacterRealm(CharactersFactory.BASE_NAME, CharactersFactory.BASE_DESCRIPTION, mockThumbnailRealm)
        val result = mapper.transform(mockCharacterRealm)
        assertBufferooDataEquality(mockCharacterRealm, result)

    }

    @Test
    fun transformToRealm() {
        val mockCharacter = CharactersFactory.getMockCharacter()
        val result = mapper.transform(mockCharacter)
        assertBufferooDataEquality(result, mockCharacter)

    }


    private fun assertBufferooDataEquality(characterRealm: CharacterRealm, marvelCard: MarvelCard) {
        Assert.assertEquals(characterRealm.name, marvelCard.header)
        Assert.assertEquals(characterRealm.description, marvelCard.description)
        Assert.assertEquals(characterRealm.thumbnail!!.path, marvelCard.thumbnail.path)
        Assert.assertEquals(characterRealm.thumbnail!!.extension, marvelCard.thumbnail.extension)


    }

}