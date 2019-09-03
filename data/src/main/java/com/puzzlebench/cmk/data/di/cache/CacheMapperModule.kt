package com.puzzlebench.cmk.data.di.cache

import com.puzzlebench.cmk.data.mapper.cache.BaseMapperCache
import com.puzzlebench.cmk.data.mapper.cache.CharacterMapperCache
import com.puzzlebench.cmk.data.model.CharacterRealm
import com.puzzlebench.cmk.domain.model.Character
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class CacheMapperModule {
    @Binds
    @Reusable
    abstract fun provideCharacterMapperCache(mapper: CharacterMapperCache): BaseMapperCache<Character, CharacterRealm>

}