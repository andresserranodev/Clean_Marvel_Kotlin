package com.puzzlebench.cmk.data.service

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.puzzlebench.cmk.data.mapper.service.CharacterMapperService
import com.puzzlebench.cmk.data.mocks.factory.CharactersFactory.Factory.getMockDataMarvelBaseResponse
import com.puzzlebench.cmk.data.service.retrofit.api.MarvelApi
import io.reactivex.Single
import org.junit.*

class CharacterServicesImplTest {

    private lateinit var characterServices: CharacterServicesImpl
    private var marvelApi = mock<MarvelApi>()
    private var characterMapperService = mock<CharacterMapperService>()

    @Before
    fun setUp() {
        characterServices = CharacterServicesImpl(marvelApi, characterMapperService)
    }

    @Test
    fun getCharacters() {
        val serviceResponse = getMockDataMarvelBaseResponse()
        whenever(marvelApi.getCharacter()).doReturn(Single.just(serviceResponse))
        characterServices.getCharacters().test()
        verify(marvelApi).getCharacter()
        verify(characterMapperService).transform(serviceResponse.data!!.result[1])
    }
}