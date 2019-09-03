package com.puzzlebench.cmk.data.di.cache

import com.puzzlebench.cmk.data.cache.CharacterDataSource
import com.puzzlebench.cmk.data.cache.realm.CharacterDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class DataSourceModule {
    @Binds
    @Reusable
    abstract fun provideCharacterDataSource(CharacterRepository: CharacterDataSourceImpl): CharacterDataSource
}