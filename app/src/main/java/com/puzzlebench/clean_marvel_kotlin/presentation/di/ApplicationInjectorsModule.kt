package com.puzzlebench.clean_marvel_kotlin.presentation.di

import dagger.Module

@Module(includes = [
    ActivityInjectorModule::class,
    CharacterModule::class
])
abstract class ApplicationInjectorsModule