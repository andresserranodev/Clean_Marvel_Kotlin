package com.puzzlebench.cmk.data.cache

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.puzzlebench.cmk.data.mapper.repository.CharacterMapperRepository
import com.puzzlebench.cmk.data.mocks.factory.CharactersFactory.Factory.getMockListCharacter
import com.puzzlebench.cmk.data.mocks.factory.CharactersFactory.Factory.getMockListCharacterRealm
import org.junit.*

class CharacterRepositoryImplTest {

    private lateinit var characterRepositoryImpl: CharacterRepositoryImpl
    private var characterDataSourceImpl = mock<CharacterDataSource>()
    private val characterMapperRepository = mock<CharacterMapperRepository>()

    @Before
    fun setUp() {
        characterRepositoryImpl = CharacterRepositoryImpl(characterDataSourceImpl, characterMapperRepository)
    }

    @Test
    fun save() {
        val listCharacter = getMockListCharacter()
        characterRepositoryImpl.save(listCharacter).test()
        verify(characterMapperRepository).transform(listCharacter[1])
        verify(characterDataSourceImpl).saveCharacters(any())


    }

    @Test
    fun getAll() {
        val dataSourceResult = getMockListCharacterRealm()
        whenever(characterDataSourceImpl.getAllCharacters()).doReturn(dataSourceResult)
        characterRepositoryImpl.getAll()
        verify(characterDataSourceImpl).getAllCharacters()
        verify(characterMapperRepository).transform(dataSourceResult[1])
    }
}