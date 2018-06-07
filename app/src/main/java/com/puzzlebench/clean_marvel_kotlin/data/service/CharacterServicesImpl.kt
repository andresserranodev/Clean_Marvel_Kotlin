package com.puzzlebench.clean_marvel_kotlin.data.service

import com.puzzlebench.clean_marvel_kotlin.data.mapper.service.CharacterMapperService
import com.puzzlebench.clean_marvel_kotlin.data.service.api.MarvelApi
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import io.reactivex.Single


class CharacterServicesImpl(private val api: MarvelResquestGenerator = MarvelResquestGenerator(), private val mapper: CharacterMapperService = CharacterMapperService()) {


    fun getCaracters(): Single<List<Character>> {

        return api.createService(MarvelApi::class.java).getCharacter().flatMap {
            Single.just(mapper.transform(it.data!!.characters))
        }
    }
}