package com.puzzlebench.clean_marvel_kotlin.presentation.di

import android.content.Context
import com.puzzlebench.clean_marvel_kotlin.presentation.MarvelApp
import dagger.Binds
import dagger.Module

@Module(includes = [
    ApplicationInjectorsModule::class
])
abstract class AppModule {

    @Binds
    internal abstract fun provideContext(application: MarvelApp): Context
}