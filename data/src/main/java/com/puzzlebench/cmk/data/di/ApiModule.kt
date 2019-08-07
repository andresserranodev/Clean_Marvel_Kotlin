package com.puzzlebench.cmk.data.di

import com.puzzlebench.cmk.data.service.MarvelResquestGenerator
import com.puzzlebench.cmk.data.service.api.MarvelApi
import dagger.Module
import dagger.Provides

@Module(includes = [MapperModule::class])
class ApiModule {
    @Provides
    fun providesMarvelApi(): MarvelApi {
        return MarvelResquestGenerator.makeMarvelService()

    }
}