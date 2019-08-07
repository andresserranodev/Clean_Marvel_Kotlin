package com.puzzlebench.cmk.data.di

import com.puzzlebench.cmk.data.mapper.service.BaseMapperService
import com.puzzlebench.cmk.data.mapper.service.CharacterMapperService
import com.puzzlebench.cmk.data.service.response.CharacterResponse
import com.puzzlebench.cmk.domain.model.Character
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class MapperModule {
    @Binds
    @Reusable
    abstract fun provideCharacterMapperService(mapper: CharacterMapperService): BaseMapperService<CharacterResponse, Character>

}