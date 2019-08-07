package com.puzzlebench.cmk.data.di.repository

import com.puzzlebench.cmk.data.repository.source.CharacterDataSource
import com.puzzlebench.cmk.data.repository.source.CharacterDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class DataSourceModule {
    @Binds
    @Reusable
    abstract fun provideCharacterDataSource(CharacterRepository: CharacterDataSourceImpl): CharacterDataSource
}