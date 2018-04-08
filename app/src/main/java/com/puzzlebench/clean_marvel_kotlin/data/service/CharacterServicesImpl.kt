package com.puzzlebench.clean_marvel_kotlin.data.service

import com.puzzlebench.clean_marvel_kotlin.data.mapper.service.CharacterMapperService
import com.puzzlebench.clean_marvel_kotlin.data.service.api.MarvelApi
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.service.CharacterServices
import io.reactivex.Observable


class CharacterServicesImpl(private val api: MarvelResquestGenerator = MarvelResquestGenerator(), private val mapper: CharacterMapperService = CharacterMapperService()) : CharacterServices {
    override fun getCharacters(): Observable<List<Character>> {
        return Observable.create { subscriber ->
            val callResponse = api.createService(MarvelApi::class.java).getCharacter()
            val response = callResponse.execute()

            if (response.isSuccessful) {
                subscriber.onNext(mapper.transform(response.body()!!.data!!.characters))
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}