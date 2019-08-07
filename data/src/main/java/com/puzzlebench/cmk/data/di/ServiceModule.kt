package com.puzzlebench.cmk.data.di

import com.puzzlebench.cmk.data.service.CharacterServicesImpl
import com.puzzlebench.cmk.domain.service.CharacterServices
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [ApiModule::class, MapperModule::class])
abstract class ServiceModule {
    @Binds
    @Reusable
    abstract fun provideCharacterServices(characterServices: CharacterServicesImpl): CharacterServices
}