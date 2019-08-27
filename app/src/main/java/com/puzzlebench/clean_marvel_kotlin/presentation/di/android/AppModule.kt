package com.puzzlebench.clean_marvel_kotlin.presentation.di.android

import android.content.Context
import com.puzzlebench.clean_marvel_kotlin.presentation.android.MarvelApp
import com.puzzlebench.clean_marvel_kotlin.presentation.di.ApplicationInjectorsModule
import dagger.Binds
import dagger.Module

@Module(includes = [
    ApplicationInjectorsModule::class
])
abstract class AppModule {

    @Binds
    internal abstract fun provideContext(application: MarvelApp): Context
}