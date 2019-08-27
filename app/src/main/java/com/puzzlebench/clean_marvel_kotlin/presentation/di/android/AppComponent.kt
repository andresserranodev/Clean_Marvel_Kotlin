package com.puzzlebench.clean_marvel_kotlin.presentation.di.android

import com.puzzlebench.clean_marvel_kotlin.presentation.android.MarvelApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AppModule::class,
            AndroidInjectionModule::class])
interface AppComponent : AndroidInjector<MarvelApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MarvelApp>()
}