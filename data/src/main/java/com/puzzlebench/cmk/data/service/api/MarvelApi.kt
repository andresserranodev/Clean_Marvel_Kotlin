package com.puzzlebench.cmk.data.service.api

import com.puzzlebench.cmk.data.service.response.CharacterResponse
import com.puzzlebench.cmk.data.service.response.ComicResponse
import com.puzzlebench.cmk.data.service.response.CreatorResponse
import com.puzzlebench.cmk.data.service.response.DataBaseResponse
import com.puzzlebench.cmk.data.service.response.MarvelBaseResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MarvelApi {
    @GET("/v1/public/characters")
    fun getCharacter(): Single<MarvelBaseResponse<DataBaseResponse<CharacterResponse>>>

    @GET("/v1/public/comics")
    fun getComics(): Single<MarvelBaseResponse<DataBaseResponse<ComicResponse>>>

    @GET("/v1/public/creators")
    fun getCreators(): Single<MarvelBaseResponse<DataBaseResponse<CreatorResponse>>>
}