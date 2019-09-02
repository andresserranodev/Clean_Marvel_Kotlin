package com.puzzlebench.cmk.data.di.Cache

import com.puzzlebench.cmk.data.cache.CharacterCacheImpl
import com.puzzlebench.cmk.domain.cache.CharacterCache
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [DataSourceModule::class, RepositoryMapperModule::class])
abstract class RepositoryModule {
    @Binds
    @Reusable
    abstract fun provideCharacterRepositoryImpl(characterCache: CharacterCacheImpl): CharacterCache
}