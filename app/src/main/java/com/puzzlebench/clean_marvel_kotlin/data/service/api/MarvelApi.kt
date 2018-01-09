package com.puzzlebench.clean_marvel_kotlin.data.service.api

import com.puzzlebench.clean_marvel_kotlin.data.service.response.CharacterResponse
import com.puzzlebench.clean_marvel_kotlin.data.service.response.DataBaseResponse
import com.puzzlebench.clean_marvel_kotlin.data.service.response.MarvelBaseResponse
import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface MarvelApi {
    @GET("/v1/public/characters")
    fun getCharacter(): Call<MarvelBaseResponse<DataBaseResponse<ArrayList<CharacterResponse>>>>
}