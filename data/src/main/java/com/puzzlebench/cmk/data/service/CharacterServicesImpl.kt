package com.puzzlebench.cmk.data.service

import com.puzzlebench.cmk.data.mapper.service.CharacterMapperService
import com.puzzlebench.cmk.data.service.retrofit.api.MarvelApi
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.service.CharacterServices
import io.reactivex.Single
import javax.inject.Inject


class CharacterServicesImpl @Inject constructor(private val api: MarvelApi, private val mapper: CharacterMapperService = CharacterMapperService()) : CharacterServices {
    override fun getCharacters(): Single<List<Character>> {
        return api.getCharacter().map { response ->
            response.data!!.result.map { characterResponse -> mapper.transform(characterResponse) }
        }
    }
}