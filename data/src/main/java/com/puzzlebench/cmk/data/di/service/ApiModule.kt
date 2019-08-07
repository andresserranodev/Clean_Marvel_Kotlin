package com.puzzlebench.cmk.data.di.service

import com.puzzlebench.cmk.data.service.MarvelResquestGenerator
import com.puzzlebench.cmk.data.service.api.MarvelApi
import dagger.Module
import dagger.Provides

@Module(includes = [ServiceMapperModule::class])
class ApiModule {
    @Provides
    fun providesMarvelApi(): MarvelApi {
        return MarvelResquestGenerator.makeMarvelService()

    }
}