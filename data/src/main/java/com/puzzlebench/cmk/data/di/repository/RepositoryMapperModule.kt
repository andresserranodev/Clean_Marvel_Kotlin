package com.puzzlebench.cmk.data.di.repository

import com.puzzlebench.cmk.data.mapper.repository.BaseMapperRepository
import com.puzzlebench.cmk.data.mapper.repository.CharacterMapperRepository
import com.puzzlebench.cmk.data.model.CharacterRealm
import com.puzzlebench.cmk.domain.model.Character
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class RepositoryMapperModule {
    @Binds
    @Reusable
    abstract fun provideCharacterMapperRepository(mapper: CharacterMapperRepository): BaseMapperRepository<Character, CharacterRealm>

}