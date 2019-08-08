package com.puzzlebench.cmk.data.di.service

import com.puzzlebench.cmk.data.mapper.service.BaseMapperService
import com.puzzlebench.cmk.data.mapper.service.CharacterMapperService
import com.puzzlebench.cmk.data.service.response.CharacterResponse
import com.puzzlebench.cmk.domain.model.Character
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class ServiceMapperModule {
    @Binds
    @Reusable
    abstract fun provideCharacterMapperService(mapper: CharacterMapperService): BaseMapperService<CharacterResponse, Character>

}