package com.puzzlebench.cmk.data.di.Cache

import com.puzzlebench.cmk.data.mapper.cache.BaseMapperCache
import com.puzzlebench.cmk.data.mapper.cache.CharacterMapperCache
import com.puzzlebench.cmk.data.model.CharacterRealm
import com.puzzlebench.cmk.domain.model.Character
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class RepositoryMapperModule {
    @Binds
    @Reusable
    abstract fun provideCharacterMapperRepository(mapper: CharacterMapperCache): BaseMapperCache<Character, CharacterRealm>

}