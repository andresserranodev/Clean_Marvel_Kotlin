package com.puzzlebench.cmk.data.di.cache


import com.puzzlebench.cmk.data.cache.CharacterCacheImpl
import com.puzzlebench.cmk.domain.cache.CharacterCache
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [DataSourceModule::class, CacheMapperModule::class])
abstract class CacheModule {
    @Binds
    @Reusable
    abstract fun provideCharacterCacheImpl(characterCache: CharacterCacheImpl): CharacterCache
}