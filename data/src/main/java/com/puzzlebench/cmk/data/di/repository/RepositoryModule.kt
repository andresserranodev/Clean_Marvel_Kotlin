package com.puzzlebench.cmk.data.di.repository

import com.puzzlebench.cmk.data.repository.CharacterRepositoryImpl
import com.puzzlebench.cmk.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [DataSourceModule::class, RepositoryMapperModule::class])
abstract class RepositoryModule {
    @Binds
    @Reusable
    abstract fun provideCharacterRepositoryImpl(CharacterRepository: CharacterRepositoryImpl): CharacterRepository
}