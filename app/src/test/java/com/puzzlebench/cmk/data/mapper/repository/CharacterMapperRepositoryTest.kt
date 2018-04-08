package com.puzzlebench.cmk.data.mapper.repository

import com.puzzlebench.cmk.data.model.CharacterRealm
import com.puzzlebench.cmk.data.model.ThumbnailRealm
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.mocks.factory.CharactersFactory
import junit.framework.Assert
import org.junit.Before
import org.junit.Test


class CharacterMapperRepositoryTest {

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


    private fun assertBufferooDataEquality(characterRealm: CharacterRealm, character: Character) {
        Assert.assertEquals(characterRealm.name, character.name)
        Assert.assertEquals(characterRealm.description, character.description)
        Assert.assertEquals(characterRealm.thumbnail!!.path, character.thumbnail.path)
        Assert.assertEquals(characterRealm.thumbnail!!.extension, character.thumbnail.extension)


    }

}