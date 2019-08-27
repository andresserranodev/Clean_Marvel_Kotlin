package com.puzzlebench.cmk.data.service.retrofit.api

import com.puzzlebench.cmk.data.service.response.CharacterResponse
import com.puzzlebench.cmk.data.service.baseresponse.DataBaseResponse
import com.puzzlebench.cmk.data.service.baseresponse.MarvelBaseResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MarvelApi {
    @GET("/v1/public/characters")
    fun getCharacter(): Single<MarvelBaseResponse<DataBaseResponse<CharacterResponse>>>
}